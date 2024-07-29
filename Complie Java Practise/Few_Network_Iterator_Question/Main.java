import java.util.*;

// javac Main.java 
// java Main

/*
Instructions

Write an iterator class that converts an integer iterator (inputIterator) into a numerical block iterator, i.e., a list-of-integer iterator. Each block is the longest possible list of contiguous integers from the inputIterator, such that:

the sum of integers in each block does not exceed a given non-negative integer blockLimit.
the first element in the block does not exceed blockLimit.


Example

inputIterator: [5, 1, 2, 1, -1, 0, 1, 10, 4, 1, 2]

blockLimit: 4



Then upon calling next() we will get the following:

next() ==> [1, 2, 1, -1, 0, 1]

next() ==> [4]

next() ==> [1, 2]

next() ==> throw java.util.NoSuchElementException



Starter Code

Use the provided starter code. You will need to fill in the following two functions:

NumericalBlockIterator.hasNext()
NumericalBlockIterator.next()
When you run the code, all the pre-built tests should pass.



Hints

Iterator: An Iterator is an interface with two methods: hasNext() and next(). hasNext() returns whether the next element is present (a boolean value). next() returns the next element if present, otherwise throws a NoSuchElementException. Iterators are commonly used to iterate over elements of a collection or over data read from files or from the network.


Implementation considerations

The solution should scale well to very large input iterators, e.g. it should be able to handle an infinite input iterator and infinite next()/HasNext() calls to the NumericalBlockIterator.
Calling hasNext() should have no effect on the returned value of the next() call.
There could be integers in the input stream which may not be part of any block, if they exceed the blockLimit. In the provided example, 5 and 10 did not show up in any of the returned blocks.


Note

This question is meant to be attempted in the Java language only - please do NOT attempt to change the language.

If you've accidentally changed the language, please change it back to Java and click on the Reset button near the top of the screen to retrieve the question template.

*/


import java.util.*;

public class Main {
  public static class NumericalBlockIterator implements Iterator<List<Integer>> {

    private Iterator<Integer> inputIterator;
    private Integer blockLimit;
    private List<Integer> nextBlock;
    private boolean hasNextBlock;
    private Integer bufferElement;
    private boolean bufferUsed;

    public NumericalBlockIterator(Iterator<Integer> inputIterator, Integer blockLimit) {
      this.inputIterator = inputIterator;
      this.blockLimit = blockLimit;
      this.nextBlock = new ArrayList<>();
      this.hasNextBlock = false;
      this.bufferElement = null;
      this.bufferUsed = false;
      prepareNextBlock();
    }

    private void prepareNextBlock() {
      nextBlock.clear();
      int currentSum = 0;
      boolean blockStarted = false;

      while (true) {
          int nextVal;

          if (bufferElement != null && !bufferUsed) {
              nextVal = bufferElement;
              bufferUsed = true;
          } else if (inputIterator.hasNext()) {
              nextVal = inputIterator.next();
          } else {
              break;
          }

          if (!blockStarted && nextVal > blockLimit) {
              continue; // Skip elements that exceed blockLimit
          }

          if (currentSum + nextVal <= blockLimit) {
              nextBlock.add(nextVal);
              currentSum += nextVal;
              blockStarted = true;
          } else {
              bufferElement = nextVal;
              bufferUsed = false;
              hasNextBlock = true;
              return;
          }
      }

      bufferElement = null;
      hasNextBlock = !nextBlock.isEmpty();
    }

    /**
     * If this iterator has more elements in it, return true without advancing
     * the internal iterator pointer.
     * Otherwise return false.
     */
    @Override
    public boolean hasNext() {
      return hasNextBlock;
    }

    /**
     * Return the next block. If no more block exists, throw
     * {@link java.util.NoSuchElementException}.
     */
    @Override
    public List<Integer> next() {
      if(!hasNextBlock) {
          throw new NoSuchElementException();
      }
      List<Integer> currentBlock = new ArrayList<>(nextBlock);
      prepareNextBlock();
      return currentBlock;
    }
  }



















  // Template code - DO NOT EDIT

  private static final Boolean HAS_NEXT = false;
  private static final Boolean NEXT = true;
  private static final String NO_SUCH_ELEMENT_EXCEPTION = "NoSuchElementException";
  private static final String TRUE = Boolean.TRUE.toString();
  private static final String FALSE = Boolean.FALSE.toString();

  public static class TestIterator implements Iterator<Integer> {
    private final List<Integer> loopArray;
    private Iterator<Integer> iterator;

    public TestIterator(List<Integer> fixedArray, List<Integer> loopArray) {
      iterator = fixedArray.isEmpty() ? loopArray.iterator() : fixedArray.iterator();
      this.loopArray = loopArray;
    }

    @Override
    public boolean hasNext() {
      return iterator.hasNext();
    }

    @Override
    public Integer next() {
      int ret = iterator.next();
      if (!iterator.hasNext())
        iterator = loopArray.iterator();
      return ret;
    }
  }

  private static class TestCase {
    public final List<Integer> fixedArray;
    public final List<Integer> loopingArray;
    public final int blockLimit;
    public final List<Boolean> commands;
    public final List<String> output;

    public TestCase(List<Integer> fixedArray, List<Integer> loopingArray, Integer blockLimit, List<Boolean> commands, List<String> output) {
      this.fixedArray = fixedArray;
      this.loopingArray = loopingArray;
      this.blockLimit = blockLimit;
      this.commands = commands;
      this.output = output;
    }

    public void printInput() {
      String inputArray = "";
      if (!fixedArray.isEmpty()) {
        inputArray += printIntArray(fixedArray);
      }
      if (!loopingArray.isEmpty()) {
        if (!inputArray.isEmpty()) {
          inputArray += ", ";
        }
        inputArray += "(";
        inputArray += printIntArray(loopingArray);
        inputArray += ")*";
      }
      System.out.println(
              "\nInput: " +
              inputArray +
              "\nblockLimit: " +
              blockLimit +
              "\nCommands applied: " +
              String.join(", ", commands.stream().map(r -> r ? "next" : "hasNext").toList()));
    }

    public void printOutput(List<String> outputs) {
      for(String output : outputs) {
        System.out.println(output);
      }
    }
  }

  private static String printIntArray(List<Integer> array) {
    return String.join(", ", array.stream().map(Object::toString).toList());
  }

  private static boolean runCase(TestCase testCase) {

    NumericalBlockIterator numericalBlockIterator = new NumericalBlockIterator(
            new TestIterator(testCase.fixedArray, testCase.loopingArray), testCase.blockLimit);
    List<String> expectedOutputs = testCase.output;
    List<String> actualOutputs = new ArrayList<>();

    List<Boolean> commands = testCase.commands;
      for (Boolean command : commands) {
          String output;
          try {
              if (command) {
                output = "[" + printIntArray(numericalBlockIterator.next()) + "]";
              } else {
                output = Boolean.valueOf(numericalBlockIterator.hasNext()).toString();
              }
          } catch (NoSuchElementException nsee) {
              output = NO_SUCH_ELEMENT_EXCEPTION;
          }
          actualOutputs.add(output);
      }

    if (actualOutputs.equals(expectedOutputs)) {
      return true;
    }

    System.out.println("___________________");
    System.out.print("FAILED TEST CASE: ");
    testCase.printInput();
    System.out.println("\nExpected: ");
    testCase.printOutput(expectedOutputs);
    System.out.println("\nFound: ");
    testCase.printOutput(actualOutputs);
    System.out.println("___________________");
    return false;
  }

  public static void main(String[] args) {
    List<TestCase> testCases = getTestCases();
    List<TestCase> passed = new ArrayList<>();

    testCases.forEach(testCase -> {
      if (runCase(testCase)) {
        passed.add(testCase);
      }
    });
    System.out.printf("\n\n%d/%d test cases passed\n\n\n", passed.size(), testCases.size());
  }

  private static List<TestCase> getTestCases() {
    return List.of(
            new TestCase(
                    List.of(5, 1, 2, 1, -1, 0, 1, 10, 4, 1, 2),
                    List.of(),
                    4,
                    List.of(HAS_NEXT, HAS_NEXT, NEXT, NEXT, HAS_NEXT, NEXT, NEXT, HAS_NEXT, HAS_NEXT),
                    List.of(TRUE, TRUE, "[1, 2, 1, -1, 0, 1]", "[4]", TRUE, "[1, 2]", NO_SUCH_ELEMENT_EXCEPTION, FALSE, FALSE)),
            new TestCase(
                    List.of(1),
                    List.of(),
                    0,
                    List.of(HAS_NEXT, NEXT, NEXT, HAS_NEXT),
                    List.of(FALSE, NO_SUCH_ELEMENT_EXCEPTION, NO_SUCH_ELEMENT_EXCEPTION, FALSE)),
            new TestCase(
                    List.of(0),
                    List.of(),
                    0,
                    List.of(HAS_NEXT, NEXT, NEXT, HAS_NEXT),
                    List.of(TRUE, "[0]", NO_SUCH_ELEMENT_EXCEPTION, FALSE)),
            new TestCase(
                    List.of(100, 100, 100, 100, 100, 1),
                    List.of(),
                    1,
                    List.of(HAS_NEXT, NEXT, NEXT, HAS_NEXT),
                    List.of(TRUE, "[1]", NO_SUCH_ELEMENT_EXCEPTION, FALSE)),
            new TestCase(
                    List.of(1, 2, 4),
                    List.of(3, 5),
                    12,
                    List.of(HAS_NEXT, NEXT, NEXT, HAS_NEXT, NEXT, NEXT, HAS_NEXT, HAS_NEXT, HAS_NEXT, HAS_NEXT),
                    List.of(TRUE, "[1, 2, 4, 3]", "[5, 3]", TRUE, "[5, 3]", "[5, 3]", TRUE, TRUE, TRUE, TRUE)),
            new TestCase(
                    List.of(),
                    List.of(1),
                    11,
                    List.of(HAS_NEXT,
                            NEXT, NEXT, NEXT, NEXT, NEXT, NEXT, NEXT, NEXT, NEXT, NEXT,
                            HAS_NEXT,
                            NEXT, NEXT, NEXT, NEXT, NEXT, NEXT, NEXT, NEXT, NEXT, NEXT,
                            NEXT, NEXT, NEXT, NEXT, NEXT, NEXT, NEXT, NEXT, NEXT, NEXT,
                            NEXT, NEXT,
                            HAS_NEXT),
                    List.of(TRUE,
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            TRUE,
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]",
                            TRUE))
            );
  }
}