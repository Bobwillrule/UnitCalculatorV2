# Unit Calculator V2

**Unit Calculator V2** is an Android app that allows you to perform unit-aware calculations with support for:  

- Mixed metric and imperial units
- Order of operations and parentheses  
- Unit conversions between compatible units  
- Easy input editing and previous answer recall  

It’s designed to make complex calculations involving units fast, accurate, and intuitive.

---

## Features

- **Number + Unit Input**: Enter values with their units, e.g., `5 m` or `12 in`.  
- **Unit-aware Operations**: Supports addition, subtraction, multiplication, and division with automatic unit handling.  
- **Previous Answer Recall**: Use the last calculated result in new expressions.  
- **Clean UI**: Large number/unit input display, responsive buttons, and rounded edges for a modern look.  

---

## Versions
This is the new and revamped version of the unit calculator. For the first version please refer to: https://github.com/Bobwillrule/Unit-Calculator


In this version we implemented:

- A completely new evaluation and parsing system:
  - Conversion from Infix to Postfix equations using Shunting-Yard Algorithm to allow faster calculation
  - Usage of stacks for calculation and conversions
  - (Original used a series (a lot) of conditionals to evaluate and parse the input)
- File division for better organization (instead of all being in main activity)
- Usage of Enums, OOD, and maps for better data organization and processing speed
- A more complete and modern UI

---

## App inspiration

Woodworking is one of my hobbies but I frequently encountered an inconvenience. In woodworking we frequently had to convert different units to one another. Metric to metric was doable with quick mental math, but especially in Canada, where a weird mix of imperial and metric units are especially prevalent and having a calculator would be less error prone than mental math, unit conversion could be hard without the help of technology. 

The Problem:
To convert to units, many of the online tools such as www.unitconverters.net only allowed you to convert units between a specific set of units.

What do I mean by this?
The steps I would need to take to calculate 6in + 5cm +10mm
1. convert 6 in to 152.4mm
2. switch the desired conversion pair from in -> mm to cm ->mm on online tools
3. convert 5 cm to 50mm
4. Evaluate 152.4mm + 50mm +10mm in my calculator
5. Further swich the answer of 212.4mm to in or cm if I want

To make steps 1 to 5 into only one input, I created the unit Calculator

---

## Example Usage

| Expression        | Result        |
|------------------|--------------|
| `6x6 m`          | `36 m`       |
| `3 m + 200 cm`   | `5 m`        |

---

 ## Sample Image
<img width="100" alt="image" src="https://github.com/user-attachments/assets/1acc5797-cb81-462a-be9d-f9a2b8c1956c" />

---
GenAI use Acknowledgement: GenAI was used for some ideas and inspiration (Ie. did not know what shunting-yard algorithm was before this project)
