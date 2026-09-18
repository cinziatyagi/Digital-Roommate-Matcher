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
## Testing Instructions

The project can be tested by running the application and checking each major functional module.

### Functional Testing

1. **Register Student**
   - Enter valid student details.
   - Verify that the student is added successfully.

2. **View and Search Students**
   - View all registered students.
   - Search using a valid student ID.
   - Verify that the correct profile is displayed.

3. **Update Student Profile**
   - Select an existing student.
   - Modify the required preferences.
   - Verify that the updated information is saved.

4. **Delete Student Profile**
   - Select an existing student.
   - Delete the profile.
   - Verify that the student no longer appears in the records.

5. **Roommate Matching**
   - Select a registered student.
   - Generate roommate matches.
   - Verify that compatible students are displayed with compatibility scores.

6. **Input Validation**
   - Enter invalid menu choices.
   - Enter invalid numeric values.
   - Leave required fields empty.
   - Verify that appropriate validation messages are displayed.

### Test Environment

- Java JDK 17 or later
- Command-line terminal
- Windows, Linux, or macOS

## Author

Cinzia Tyagi
