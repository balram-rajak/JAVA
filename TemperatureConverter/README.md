# Temperature Converter

## Description
A console application that converts temperatures between Celsius and Fahrenheit. Users can choose to convert from Celsius to Fahrenheit or vice versa.

## Concepts Covered
- User input with `Scanner` class
- Mathematical calculations
- Conditional statements (if-else)
- Menu-driven programs
- Formula implementation

## How to Run
1. Compile the program:
   ```bash
   javac TemperatureConverter.java
   ```

2. Run the program:
   ```bash
   java TemperatureConverter
   ```

3. Follow the prompts:
   - Choose conversion type (1 for C to F, 2 for F to C)
   - Enter the temperature value

## Example Usage
```
Temperature Converter
1. Celsius to Fahrenheit
2. Fahrenheit to Celsius
Choose an option: 1
Enter temperature: 25
25.0°C = 77.0°F
```

## Formulas Used
- Celsius to Fahrenheit: `F = (C × 9/5) + 32`
- Fahrenheit to Celsius: `C = (F - 32) × 5/9`

## Learning Objectives
- Implement mathematical formulas in Java
- Create menu-driven applications
- Handle user choices with conditional logic
- Format output with special characters (°)

## Future Enhancements
- Add Kelvin conversion
- Add input validation
- Support multiple conversions in one session
- Create a GUI version
