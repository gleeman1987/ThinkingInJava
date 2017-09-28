package chapter14runtimetypeinfo;

import java.util.ArrayList;

public class People {
    public final String first;
    public final String last;
    public final String address;

    public People(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    @Override
    public String toString() {
        return "People{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static final People Null = new NullPeople();

    public static class NullPeople extends People implements chapter14runtimetypeinfo.Null {

        public NullPeople() {
            super("None", "None", "None");
        }

        @Override
        public String toString() {
            return "NonePeople";
        }
    }
}

interface Null{}

class Position {
    private String title;
    private People people;

    public Position(String title, People people) {
        this.title = title;
        this.people = people;
        if (people == null) {
            this.people = People.Null;
        }
    }

    public Position(String title) {
        this.title = title;
        this.people = People.Null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
        if (people == null) {
            this.people = People.Null;
        }
    }

    @Override
    public String toString() {
        return "Position{" +
                "title='" + title + '\'' +
                ", people=" + people +
                '}';
    }
}

class Stuff extends ArrayList<Position>{
    public void add(String title, People people){
        add(new Position(title,people));
    }

    public void add(String... titles){
        for (String title : titles) {
            add(new Position(title));
        }
    }

    public Stuff(String... titles) {
        add(titles);
    }

    public boolean positionAvailable(String title){
        for (Position position : this) {
            if (position.getTitle().equals(title) && position.getPeople() == People.Null) {
                return true;
            }
        }
        return false;
    }

    public void fillPosition(String title, People hire){
        for (Position position : this) {
            if (position.getTitle().equals(title) && position.getPeople() == People.Null) {
                position.setPeople(hire);
                return;
            }
        }
        throw new RuntimeException("Position " +
                title +
                " not Available");
    }

    public static void main(String[] args) {
        Stuff positions = new Stuff("President", "CTO", "Market Manager", "Product Manager", "Project Manager", "Project Leader", "Software Engineering", "Software Engineering", "Test Engineer");
        positions.fillPosition("President",new People("Me","Last","Queenz's Town"));
        positions.fillPosition("Market Manager",new People("Britney","Spears","Queenz's Town"));
        if (positions.positionAvailable("Software Engineering")) {
            positions.fillPosition("Software Engineering",new People("Mickael","Jackson","Queenz's Town"));
        }
        System.out.println(positions);
    }
}
