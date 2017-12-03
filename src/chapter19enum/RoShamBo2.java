package chapter19enum;

/**
 * Authur:zhengjun
 * E-mail:zhengjun1987@outlook.com
 * Date:2017/12/3
 * Project:ThinkingInJava
 */
public enum  RoShamBo2 implements Competitor<RoShamBo2> {
    PAPER(Outcome.DRAW,Outcome.LOSE,Outcome.WIN),
    SCISSORS(Outcome.WIN,Outcome.DRAW,Outcome.LOSE),
    ROCK(Outcome.LOSE,Outcome.WIN,Outcome.DRAW);

    private Outcome vPaper,vScissor,vRock;

    RoShamBo2(Outcome vPaper, Outcome vScissor, Outcome vRock) {
        this.vPaper = vPaper;
        this.vScissor = vScissor;
        this.vRock = vRock;
    }

    @Override
    public Outcome compete(RoShamBo2 competitor) {
        switch (competitor) {
            case SCISSORS:
                return vScissor;
            case PAPER:
                return vPaper;
            case ROCK:
                return vRock;
        }
        return null;
    }

    public static void main(String[] args) {
        for (int i = 0; i < RoShamBo1.SIZE; i++) {
            Competitor a = Enums.random(RoShamBo2.class);
            Competitor b = Enums.random(RoShamBo2.class);
            System.out.println( a + " vs " + b + "  outcome:"+(a.compete(b)));
        }
//        ROCK vs ROCK  outcome:DRAW
//        SCISSORS vs ROCK  outcome:LOSE
//        SCISSORS vs ROCK  outcome:LOSE
//        SCISSORS vs ROCK  outcome:LOSE
//        PAPER vs SCISSORS  outcome:LOSE
//        PAPER vs PAPER  outcome:DRAW
//        PAPER vs SCISSORS  outcome:LOSE
//        ROCK vs SCISSORS  outcome:WIN
//        SCISSORS vs SCISSORS  outcome:DRAW
//        ROCK vs SCISSORS  outcome:WIN
//        SCISSORS vs PAPER  outcome:WIN
//        SCISSORS vs PAPER  outcome:WIN
//        ROCK vs PAPER  outcome:LOSE
//        ROCK vs SCISSORS  outcome:WIN
//        SCISSORS vs ROCK  outcome:LOSE
//        PAPER vs SCISSORS  outcome:LOSE
//        SCISSORS vs PAPER  outcome:WIN
//        SCISSORS vs PAPER  outcome:WIN
//        SCISSORS vs PAPER  outcome:WIN
//        SCISSORS vs PAPER  outcome:WIN
    }
}
