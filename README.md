# BODMAS Calculator

This is a simple BODMAS calculator implemented in Java. It evaluates mathematical expressions according to the BODMAS rules (Brackets, Orders, Division and Multiplication, Addition and Subtraction).

## Getting Started

### Prerequisites

- Download IntelliJ IDEA from [JetBrains](https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows).

### Running the Program

1. Clone or download the repository containing the project.
2. Open the project in IntelliJ IDEA.
3. Navigate to the `src` folder and locate `BODMASCalculator.java`.
4. Run the program.

### How to Use

- When prompted, enter your mathematical expression, for example:
Enter your expression: 26(33+23-11(21/3)+792122)+(78/2)

- The program will evaluate the expression according to BODMAS logic.

### Example Expressions
You can try different expressions to see how the calculator evaluates them. For example:
- `3 + 5 * 2`
- `(4 + 6) * 2`
- `2 * (3 + 5) - 4 / 2`

## How the Calculator Works

1. **Input Parsing**: The calculator reads the input expression as a string, removing any unnecessary whitespace to simplify processing.

2. **Handling Parentheses**: It first evaluates any expressions within parentheses. This is done recursively, ensuring that innermost expressions are solved first.

3. **Using Stacks**:
 - **Number Stack**: Stores numbers for evaluation.
 - **Operator Stack**: Stores operators to manage the order of operations.
 - As the program reads through the expression, it pushes numbers onto the number stack and operators onto the operator stack.

4. **Operator Precedence**: The calculator applies multiplication and division before addition and subtraction based on operator precedence. This ensures that the expression is evaluated correctly according to BODMAS rules.

5. **Final Calculation**: Once all tokens are processed, any remaining operators are applied to the numbers in the stack, and the final result is outputted.

Feel free to experiment with various expressions to see how the BODMAS calculator evaluates them!


