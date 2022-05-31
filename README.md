# JWordle <a href="https://github.com/Jinyuan-S/JWordle"> <img src="https://github.githubassets.com/images/modules/site/icons/footer/github-mark.svg" width="3%"></a>
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
javac -d . ./src/JWordle/*.java && java JWordle.Start
```

## Preference
+ #### A large wordlist which contains of 2500+ words.
+ #### An user friendly interface.
+ #### adapt to MacOSX system.

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

### v1.3

**about:** added login interface and restart function.

**already have：**

1. Basic GUI window
2. Sinple input logic, button action
3. Wordlist check, Legality check
4. Simple pop-window reminder
5. Login
6. Restart(with bug)

**Todo：**

1. Menu page
2. Account & userlogin(logic)
3. fix bug in restart


### v1.4

**about:** added not enough word alert, update javadoc.

**already have：**

1. Basic GUI window
2. input logic, button action
3. Wordlist check, Legality check
4. pop-window alert
5. Restart

**Todo：**

1. Menu page
2. Account & userlogin(logic)