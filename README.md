# University Student Record & Campus Route Management System

## Project Overview
This project is a Java console application developed for the CIT300 Data Structures and Algorithms module. It integrates a university student management system with a campus route and network traversal module. The application demonstrates the core operations (insertion, deletion, updating, searching, and traversal) across several custom-built linear and non-linear data structures without relying on third-party frameworks.

---

## Group Information & Member Contributions

| Student ID | Student Name | Assigned Component | Responsibilities & Individual Contributions |
| :--- | :--- | :--- | :--- |
| **STXXXX1** | **[Member 1 Name]** | Linked List & Menu System | Implemented `Student.java`, `StudentLinkedList.java` for fundamental CRUD operations, and integrated the interactive menu loop in `Main.java`. |
| **STXXXX2** | **[Member 2 Name]** | Stack & Queue | Developed `ActionStack.java` for tracking system activity logs and `StudentQueue.java` for managing student service queues and deletions. |
| **STXXXX3** | **[Member 3 Name]** | Binary Search Tree & Hash Table | Implemented `StudentBST.java` (including recursive insertion, searching, deletion, and in-order traversal) and `StudentHashTable.java` with linear probing. |
| **STXXXX4** | **[Member 4 Name]** | Campus Graph & Traversals | Implemented `CampusGraph.java` using an adjacency list model along with Breadth-First Search (BFS) and Depth-First Search (DFS) graph traversal algorithms. |

---

## Data Structures & Implementation Details

1. **Singly Linked List (`StudentLinkedList`)**
   - Stores primary student records (`Student ID`, `Name`, `Programme`, `Marks`).
   - Handles `addStudent`, `updateStudent`, `deleteStudent`, and `searchStudent` operations.

2. **Stack (`ActionStack`)**
   - Tracks recent system actions (e.g., student additions, updates, deletions) using LIFO (Last-In, First-Out) operations (`push`, `pop`, `peek`).

3. **Queue (`StudentQueue`)**
   - Manages student service arrivals in FIFO (First-In, First-Out) order. Supports `enqueue`, `dequeue`, `peek`, and custom node deletion.

4. **Binary Search Tree (`StudentBST`)**
   - Organizes students hierarchically based on `Student ID`.
   - Supports search, deletion with successor rebalancing, and alphabetical `in-order` traversal.

5. **Hash Table (`StudentHashTable`)**
   - Implements direct key lookup using student ID character hash values.
   - Handles hash collisions using **Linear Probing**.

6. **Graph Network (`CampusGraph`)**
   - Models physical campus locations as vertices and roads as undirected edges using an Adjacency List (`Map<String, List<String>>`).
   - Performs network exploration using **Breadth-First Search (BFS)** and **Depth-First Search (DFS)** traversals.

---

## Program Features & Menu Structure

```text
======================================
       STUDENT MANAGEMENT SYSTEM
======================================
1. Display Students (Linked List)
2. Search Student (Linked List)
3. Add Student (Syncs across Linked List, BST, Hash Table, Queue)
4. Update Student
5. Delete Student (Syncs across Linked List, BST, Hash Table, Queue)
6. Student Queue (Display Front Student & Queue Status)
7. Recent Actions (View Activity Stack Log)
8. BST Operations (In-Order Traversal & BST Search)
9. Hash Table (Display Slots & Search via Hashing)
10. Campus Graph (Display Connections, Run BFS & DFS Traversals)
0. Exit
======================================
