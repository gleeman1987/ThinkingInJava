package chapter19enum;

import chapter15generics.Generator;

import java.util.EnumMap;
import java.util.Iterator;

import static chapter19enum.Input.*;


/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/2
 * Mail:zhengjun1987@outlook.com
 */
enum Category {
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION(TOOTHPASTE, CHIPS, SOAP, SODA),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);
    private Input[] inputs;

    Category(Input... inputs) {
        this.inputs = inputs;
    }

    private static EnumMap<Input, Category> categoryEnumMap = new EnumMap<>(Input.class);

    static {
        for (Category category : Category.class.getEnumConstants()) {
            for (Input input : category.inputs) {
                categoryEnumMap.put(input, category);
            }
        }
    }

    public static Category categorize(Input input) {
        return categoryEnumMap.get(input);
    }
}

public class VendingMachine {
    private static State state = State.RESTING;
    private static int amount = 0;
    private static Input selection = null;

    enum StateDuration {TRANSIENT}

    enum State {
        RESTING {
            @Override
            void next(Input input) {
                switch (Category.categorize(input)) {
                    case SHUT_DOWN:
                        state = TERMINAL;
                        break;
                    case MONEY:
                        amount += input.getValue();
                        state = ADDING_MONEY;
                        break;
                }
            }
        },
        ADDING_MONEY {
            @Override
            void next(Input input) {
                switch (Category.categorize(input)) {
                    case SHUT_DOWN:
                        state = TERMINAL;
                        break;
                    case QUIT_TRANSACTION:
                        state = GIVING_CHANGE;
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if (selection.getValue() > amount) {
                            System.out.println("Insufficient money for " + selection);
                        } else {
                            state = DISPENSING;
                        }
                        break;
                    case MONEY:
                        amount += input.getValue();
                        break;
                }
            }
        },
        DISPENSING(StateDuration.TRANSIENT) {
            @Override
            void next() {
                System.out.println("Here is your " + selection);
                amount -= selection.getValue();
                state = GIVING_CHANGE;
            }
        },
        GIVING_CHANGE(StateDuration.TRANSIENT) {
            @Override
            void next() {
                if (amount > 0) {
                    System.out.println("Your change: " + amount);
                    amount = 0;
                }
                state = RESTING;
            }
        },
        TERMINAL {
            @Override
            void output() {
                System.out.println("Halted!");
            }
        };

        void next() {
            throw new RuntimeException("next() invocation only available for transient states");
        }

        void next(Input input) {
            throw new RuntimeException("next(Input input) invocation only available for non-transient states");
        }

        void output() {
            System.out.println("amount = " + amount +"  state = "+state);
        }

        State() {
        }

        private boolean isTransient = false;

        State(StateDuration stateDuration) {
            this.isTransient = true;
        }

        static void run(Generator<Input> generator) {
            while (state != TERMINAL) {
                state.next(generator.next());
                while (state.isTransient) {
                    state.next();
                }
                state.output();
            }
        }

        public static void main(String[] args) {
            RandomInputGenerator randomInputGenerator = new RandomInputGenerator();
            run(randomInputGenerator);
        }
//        0
//                0
//                100
//                125
//                135
//                145
//        Here is your SODA
//        Your change: 45
//                0
//                0
//                0
//                0
//                5
//                30
//                35
//        Insufficient money for CHIPS
//        35
//        Your change: 35
//                0
//                25
//                50
//        Here is your SOAP
//        0
//        0
//        25
//        Insufficient money for CHIPS
//        25
//        125
//        135
//        145
//        170
//        Insufficient money for TOOTHPASTE
//        170
//        Your change: 170
//                0
//                0
//                0
//                0
//                5
//        Insufficient money for SOAP
//        5
//        Insufficient money for SODA
//        5
//        Insufficient money for TOOTHPASTE
//        5
//        Insufficient money for SODA
//        5
//        Insufficient money for TOOTHPASTE
//        5
//        30
//        Insufficient money for SODA
//        30
//        Insufficient money for TOOTHPASTE
//        30
//        Your change: 30
//        0
//        100
//        Halted!
    }

}

class RandomInputGenerator implements Generator<Input> {
    @Override
    public Input next() {
        return Input.randomSelection();
    }
}

class FileInputGenerator implements Generator<Input> {
    private Iterator<String> input;

    public FileInputGenerator(String fileName) {
//        this.input = new TextFile(fileName,";").iterator();
    }

    @Override
    public Input next() {
        System.out.println("FileInputGenerator.next  " + "");
        return Input.randomSelection();
    }
}