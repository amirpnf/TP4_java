# TP4 java - Amirhossein Pouyanfar - Group 2 Mr. Rémy Forax

### Exercise 2

4. The `for-each` loop is transformed into a `while` on an `Iterator` object by the compilator.
This fact is deduces, by observing this line in the bytecode :
```bash
4: invokevirtual #26                 // Method java/util/ArrayList.iterator:()Ljava/util/Iterator;
9: invokeinterface #30,  1           // InterfaceMethod java/util/Iterator.hasNext:()Z
18: invokeinterface #36,  1           // InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
```

5. In Java, we prefer to have two types of methods : 
First, those who modify something, have `void` as their return value.
Second, those who calculate, or achieve something, which they return,
thus their return value type would be that.

6. Here's a `toString()` method, printing a library's books, separated by commas (`", "`):
```java
public String toString() {
	var res = new StringBuilder();
	var separator = "";
	for(var book : books) {
		res.append(separator).append(book);
		separator = ", ";
	}
	return res.toString();
	}
```

### Exercise 3

1. The `findByTitle` method that we defined in the `Library` class, has a complexity of `O(n)`, it 
loops through the book ArrayList, passing once through each book.
2. java.util.HashMap is the implementation of the Hash Table, permitting null values and null keys
(as opposed to Hashtable), 