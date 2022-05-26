# JWordle
An Java version Wordle based on Swing

## How to play
- Guess the Wordle word in tries for no more than 6 time.
- Each guess must be a valid word with the length of **FIVE**.
- For each letter in a valid word(ie. in a wordlist) you enter, it will turn to:
    - **Green** if it is in the answer with correct position.
    - **Yellow** if it is in the answer with the wrong position.
    - **Gray** if it is not in the answer.


### Compile & Run
```shell
cd ./src
javac JWordle/*.java && java JWordle/Start
```

### Regenerate the Javadoc

```shell
javadoc -d ./doc ./src/JWordle/*.java 
```

## Developing Log

### v1.0

**about:** the first part of function.

**already have：**

1. Basic GUI window
2. Sinple input logic, button action

**Todo：**

1. Wordlist check
2. Menu
3. Prompt window

### v1.1

**about:** complement the javadoc annotation.

**already have：**

1. Basic GUI window
2. Sinple input logic, button action
3. Wordlist check, Legality check
4. Simple pop-window reminder

**Todo：**

1. Menu page
2. Account & userlogin


