````md
# SQL Keywords Explained Like You Are 5 Years Old

Think of **SQL keywords** like magic words you say to your toy robot so it knows what to do with your toy boxes.  
SQL is just a language we use to talk to a database, and **keywords** are the main action words.

This guide explains important SQL keywords in very simple words, but with enough detail to help you really understand.

---

# What are SQL Keywords?

SQL keywords are special words that tell the database:

- "Show me something"
- "Add new data"
- "Change data"
- "Delete data"
- "Make a new table"

They are like instructions.

## Example

```sql
SELECT name FROM students;
````

Here:

* `SELECT` = show
* `FROM` = where to look

---

# 1. SELECT (Show Me Data)

Imagine asking:

"Robot, show me my red toys."

`SELECT` means bring or display data.

## Example

```sql
SELECT * FROM students;
```

Simple meaning:
Show me everything from the students table.

---

# 2. FROM (Where to Look)

`FROM` tells the database which toy box (table) to open.

## Example

```sql
SELECT name FROM students;
```

Meaning:
Go to the students box and show names.

---

# 3. WHERE (Pick Only Some Things)

Sometimes you don’t want all toys, only specific ones.

`WHERE` is like saying:
"Only give me blue cars."

## Example

```sql
SELECT * FROM students WHERE age = 10;
```

Meaning:
Show only students who are age 10.

---

# 4. INSERT (Add New Toy)

When you get a new toy and put it into the box, that is `INSERT`.

## Example

```sql
INSERT INTO students (name, age) VALUES ('Ravi', 10);
```

Meaning:
Add Ravi into the students table.

---

# 5. UPDATE (Change Something)

If you painted your toy a new color, you changed it.

`UPDATE` means modify existing data.

## Example

```sql
UPDATE students SET age = 11 WHERE name = 'Ravi';
```

Meaning:
Change Ravi’s age to 11.

---

# 6. DELETE (Remove a Toy)

If you remove a toy from the box, that is `DELETE`.

## Example

```sql
DELETE FROM students WHERE name = 'Ravi';
```

Meaning:
Remove Ravi from the table.

---

# 7. CREATE (Make a New Box)

Before keeping toys, you need a box.

`CREATE` makes a new table.

## Example

```sql
CREATE TABLE students (
  id INT,
  name VARCHAR(50)
);
```

Meaning:
Make a new table called students.

---

# 8. DROP (Throw Away the Whole Box)

`DROP` is strong.
It deletes the whole table.

## Example

```sql
DROP TABLE students;
```

Meaning:
Remove the entire students box.

---

# 9. ORDER BY (Arrange Toys Nicely)

If you want toys sorted by size or color, use `ORDER BY`.

## Example

```sql
SELECT * FROM students ORDER BY age;
```

Meaning:
Show students sorted by age.

---

# 10. GROUP BY (Make Toy Groups)

If you want toys grouped, use `GROUP BY`.

## Example

```sql
SELECT age, COUNT(*) FROM students GROUP BY age;
```

Meaning:
Group students by age.

---

# Easy Kid Summary

* SELECT = show toys
* INSERT = add toy
* UPDATE = change toy
* DELETE = remove toy
* CREATE = make box
* DROP = delete box
* WHERE = choose which toy
* ORDER BY = arrange toys

```
```
