# Digital Roommate Matcher

A Java-based command-line application that matches students based on their roommate preferences and lifestyle compatibility.

## Features

- Register a new student profile
- View all registered students
- Search students by ID or name
- Update an existing profile
- Delete a student profile
- Find compatible roommate matches
- View complete student details
- Store student data using a text file

## Matching Criteria

The roommate matching score is calculated out of 100 based on:

| Preference | Weight |
|---|---:|
| Sleep Schedule | 20 |
| Study Schedule | 15 |
| Cleanliness | 15 |
| Noise Preference | 15 |
| AC Preference | 10 |
| Social Preference | 10 |
| Food Preference | 5 |
| Room Preference | 5 |
| Hobbies | 5 |
| **Total** | **100** |

Students with higher scores have more matching preferences.

## Project Structure

```text
Digital-Roommate-Matcher/
├── src/
│   ├── Main.java
│   ├── Student.java
│   ├── RoommateMatcher.java
│   ├── MatchResult.java
│   └── DataManager.java
├── data/
│   └── students.txt
└── README.md
