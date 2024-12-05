online-shop-testing
===================

A project to practice unit testing.

Exercises
---------

1. Create a test to check that addComment returns false when a comment form the same author already exists.

2. create a test that performs negative testing on the boundaries of the rating range. That is, test the Values 0 and 6 as a rating - the values just outside the valid range. You will discover a bug, make sure that the test fails!

2. try to find the cause of the bug with a manual walkthrough and try to fix it.

3. (for the bored)Create tests for SalesItem that test whether the findMostHelfulComment method works as expected.
During your testing, you can use the Get button in the method result dialog to get the result object onto the object bench, which then allows you to make further method calls and add assertions for this object. This alows you to identify the comment object returned (e.g. by checking its author).



Original Readme
---------------
Project: online-shop-junit
Authors: Michael Kölling and David J. Barnes

This project is part of the material for the book

   Objects First with Java - A Practical Introduction using BlueJ
   Sixth edition
   David J. Barnes and Michael Kölling
   Pearson Education, 2016

This project implements a small part of an online sales system (such as Amazon.com).
The current project is concerned only with customer comments for sales items. It contains
code to create, store, show and manipulate customer comments.

The purpose of this project is to introduce regression testing using JUnit. It includes
a test class that demonstrates some of the testing functionality. Testing is further
discussed in the book.

NOTE: There are several serious errors to be found in these classes.
