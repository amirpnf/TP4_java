# TP4 java - Amirhossein Pouyanfar (262575) - Group 2 Mr. Rémy Forax

### Exercise 1

6. Écrire une classe Main qui affiche Hello Eclipse.

**Answer** : Here's a `Main` class, printing "Hello Eclipse" :
```java
public class Main {
  public static void main(String[] args) {
	System.out.println("Hello Eclipse");
  }
}
```

7. À faire à la maison pour le compte rendu:

(1) Que fait sysout + Ctrl + Space dans un main ?
(2) Que fait toStr + Ctrl + Space dans une classe ?
(3) Définir un champs foo de type int, que fait get + Ctrl + Space, et set + Ctrl + Space .
(4) Dans le menu Source, comment générer un constructeur initialisant le champ foo ?
(5) Sélectionner le nom de la classe puis Alt + Shift + R, qu'obtient-on ? Même question avec le champ foo .
(6) Écrire a = 2 + 3 + 4, puis sélectionner 2 + 3 puis Alt + Shift + L .
(7) Écrire new Integer(2), en gardant le curseur après `)`, appuyer sur Ctrl + Shift + 1, que se passe-t-il ?
(8) Déclarer une variable s de type String et cliquer sur String en maintenant la touche Ctrl . Que se passe-t-il ?
(9) Dans la méthode toString(), que fait un Ctrl + Clic sur super.toString() ?
(10) Sélectionner le champs foo, puis Ctrl + Shift + G. Que se passe-t-il ?
(11) À quoi sert Ctrl + Shift + O ?
(12) À quoi sert Ctrl + Shift + C ?


**Answers** : Here are the answers to Exercise 7:
1. In eclipse, if you type `sysout` in a `main` and press `Ctrl + Space`, eclipse
	will automatically expand it to `System.out.println();`
2. Using eclipse, if you type `toStr` in a main and then press `Ctrl + Space`, eclipse
	will automatically generate you a `toString()` method for the class.
3. If you define a field named `Foo` of type `int`, then type `get` and press `Ctrl + Space`,
	eclipse will generate you a gette method for the field like this:
	```java
	public int getFoo() {
	  return foo;
	}
	```
	if you type `set` and then press `Ctrl + Space`, eclipse will generate you a setter method like this:
	```java
	public void setFoo(int foo) {
	  this.foo = foo;
	}
	```
4. Go to the `Source` menu and click on `Generate Constructor using Fields...`. A dialog box will appear,
displaying a list of available fields in that class. Make sure that the field `foo` is selected in the list.
Finally click on the OK button.
5. When you select a class name and maintain `Alt + Shift + R`, you are triggering "Rename" refactoring feature.
this allows you to quickly rename the selected class (or field) throughout your codebase without manually scrolling,
searching and renaming each occurence.
6. This allows you to extract the selected expression into a new separate local variable.
7. This triggers the `Quick Fix` feature. You can then toggle through various potential quick fixes 
or improvements to your code based on the context.
8. Ctrl-clicking in eclipse is a navigation feature. It allows you to quickly navigate to the declaration or
definition of a variable or type. However, in this case we are Ctrl-clicking on a core Java type like String,
in our code, there is no declaration for String !
9. That would take you to the source code of the `toString()` method of the superclass from which the class you're working on is 
extending.
10. It will trigger the `References in Workspace` feature, that allows you to search for and view all the references to the
selected field throughout your workspace, including all the packages. It will open a Search tab showing these references.
11. When you press `Ctrl + Shift + O`, eclipse will automatically add, remove , and organize the import statements 
in your java source code files. By doing this, you will make sure that you have the correct and necessary import statements.
12. It's used to toggle the comment status of the selected code blocks or lines. If these blocks or lines are already commented,
it will uncomment them.

### Exercise 2

 On souhaite écrire une classe Library pour modéliser une bibliothèque et permettant de stocker des livres, de telle façon que le code suivant fonctionne :
```java
  public class Main {
    public static void main(String[] args) {
      var library = new Library();
      library.add(book);
      System.out.println(library.findByTitle("Da Vinci Code"));
    }
  }
```   

La classe Main doit être dans le package par défaut (directement dans src).
Pour stocker les livres, nous allons utiliser la classe java.util.ArrayList qui est une implantation d'un tableau dynamique (qui s'agrandit si nécessaire).

Vous utiliserez le record Book suivant
```java
package fr.uge.library;

public record Book(String title, String author) {
  public Book {
    Objects.requireNonNull(title);
    Objects.requireNonNull(author);
  }
 
  @Override
  public String toString() {
    return title + " by " + author;
  }
}
```   

Avec Eclipse, faire un copier-coller du code ci-dessus dans le répertoire src (oui, ça fonctionne !). 

1. Dans le package fr.uge.library, écrire une classe Library avec un champs books de type ArrayList ainsi qu'un constructeur sans paramètre initialisant le champ books.
Attention à déclarer les bons modificateurs pour le champ books.
Note : il est possible que le compilateur lève un warning, si c'est le cas, comment corriger le problème ? 
2. Ajouter une méthode add qui permet d'ajouter des books (non null) à la liste de livres.
3. Écrire une méthode findByTitle qui permet de trouver un livre en fonction de son titre dans la bibliothèque. La méthode doit renvoyer null dans le cas où aucun livre n'a le bon titre. 

**Answers** : Here is a `Library` class, having a field `books` of type `ArrayList`, with a constructor initializing this
field. In addition to that, we have added an `add` method, which will be used to add new book to our library. Finally, we 
have defined a `findByTitle` method which allows us to find a book by its title.
```java
package fr.uge.library;

import java.util.ArrayList;
import java.util.Objects;

public class Library {
  private final ArrayList<Book> books;
	
  public Library () {
	books = new ArrayList<Book>();
  }
	
  public void add(Book b) {
	Objects.requireNonNull(b);
	this.books.add(b);
  }
	
  public Book findByTitle(String title) {
	for(var book : books) {
	  if(book.title().equals(title)) {
		return book;
	  }	 
	}
	return null;
  }
	
  @Override
  public String toString() {
	var res = new StringBuilder();
	var separator = "";
	for(var book : books) {
	  res.append(separator).append(book);
	  separator = ", ";
	}
	return res.toString();
  }
	
  public static void main(String[] args) {
	var library = new Library();
	Book book1 = new Book("Da Vinci Code", "Dan Brown");
	Book book2 = new Book("Harry Potter and the Order of the Phoenix", "J.K Rowling");
	Book book3 = new Book("Grapes of Wrath", "John Steinbeck");
	library.add(book1);
	library.add(book2);
	library.add(book3);
	System.out.println(library.findByTitle("Da Vinci Code"));
	System.out.println(library);
  }
}

```

4. Comment le compilateur compile-t-il une boucle foreach sur une collection ?
Utiliser la commande javap pour vérifier !
```bash
    javap -c Library.class
```     

**Answer** : The `for-each` loop is transformed into a `while` on an `Iterator` object by the compilator.
This fact is deduces, by observing this line in the bytecode :
```bash
4: invokevirtual #26                 // Method java/util/ArrayList.iterator:()Ljava/util/Iterator;
9: invokeinterface #30,  1           // InterfaceMethod java/util/Iterator.hasNext:()Z
18: invokeinterface #36,  1           // InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
```

5. Expliquer pourquoi la méthode findByTitle doit renvoier null plutôt que de lever une exception.  

**Answer** : In Java, we prefer to have two types of methods : 
First, those who modify something, have `void` as their return value.
Second, those who calculate, or achieve something, which they return,
thus their return value type would be that.

6. Écrire une méthode toString affichant les livres de la bibliothèque dans l'ordre d'insertion, avec les livres séparés par une virgule (avec un espace après la virgule).  

**Answer** : Here's a `toString()` method, printing a library's books, separated by commas (`", "`):
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

L'implantation faite dans l'exercice précédent est lente si la méthode findByTitle est appelée fréquemment. On va changer l'implantation en gardant la même API, c'est à dire avec les mêmes méthodes publiques (ayant les mêmes signatures). De cette façon, il ne sera pas nécessaire de changer le code du main ! 

1. Quelle est la complexité de la méthode `findByTitle` de la classe Library ? 

**Answer** : The `findByTitle` method that we have defined in the `Library` class, has a complexity of `O(n)`, it 
loops through the book ArrayList, passing once on each book.

2. Regarder la javadoc de la classe java.util.HashMap ainsi que celle de ses méthodes put et get.
Quelle est la structure de données algorithmique dont java.util.HashMap est une implantation ?
Sachant que l'on veut améliorer la performance de findByTitle comment peut on utiliser la classe java.util.HashMap pour cela ?
Quelle sera alors la complexité de findByTitle ? 

**Answer** : The data structure underlying `java.util.HashMap` is a Hash Table. A Hash Table is a data structure in 
the Java standard library who allows for efficient key-value pair storage and retrieval, often with constant-time
average complexity for basic operations like insertion, deletion, lookup etc., under favorable conditions.
A Hash Map allows `null` values and `null` keys(as opposed to Hashtable).
The `get` method of this class, returns the value to which the specified key
is mapped, returns `null` if this map contains no mapping for that key. If the `get` method returns `null`,
that doesn't necessarily mean that the map doesn't contain any mapping for that key, it might explicitly map
that key to `null` value. 
The `put` method associates the specified value with the specified key in the map. If the map already contains a 
value for this key, the old value is replaced. 
We can improve the performance of the `findByTitle` method, using `java.util.HashMap` class. We can create a hash 
map, with book titles **keys** and `Book` records as **values**.
The complexity of a simple look-up in our hash map would be O(1) on average, thanks to the way hash maps are designed.

3. Commenter entièrement le code de la classe Library (pour ne pas perdre votre travail) et recopier les signatures des méthodes commentées. Pour l'instant, laisser la méthode toString de côté. Modifier les champs afin d'utiliser une java.util.HashMap et implanter les méthodes le constructeur et les méthodes add et findByTitle. 

**Answer** : Here's the modified version of our `Library` class :
```java
package fr.uge.library;

import java.util.HashMap;

import java.util.Objects;

public class Library {
  private final HashMap<String, Book> books;
  public Library {
	books = new HashMap<String, Book>;
  }	

  public void add(Book b) {
	Objects.requireNonNull(b);
	books.put(b.title(), b);
  }

  public Book findByTitle(String title) {
	return books.get(title);
  }

  public static void main(String[] args) {
	var library = new Library();
	Book book1 = new Book("Da Vinci Code", "Dan Brown");
	Book book2 = new Book("Harry Potter and the Order of the Phoenix", "J.K Rowling");
	Book book3 = new Book("Grapes of Wrath", "John Steinbeck");
	library.add(book1);
	library.add(book2);
	library.add(book3);
	System.out.println(library.findByTitle("Da Vinci Code"));
	}
}
```

4. Expliquer pourquoi, ici, on a préféré utiliser une classe pour représenter Libary plutôt qu'un record. 

**Answer** : First of all, this `Library` class is expected to have behavior beyond simply storing data,
Classes are well-suited for encapsulating both data and behavior.  
Secondly, The `Library` class allows for easy modification of the `books` collection by adding books. Records
are immutable by default, and their components cannot be changed after they are set. Since a library's collection
changes in real life, mutable data structures like `HashMap` are required. 
Lastly, records are designed for simple data-holding classes. In a real-world library application, you might need to have
additional methods and behaviors that aren't necessarily supported by records, thus, we'd better use a class here. 

5. Pour l'implantation de la méthode toString, quelle méthode de java.util.HashMap doit-on utiliser pour obtenir l'ensemble des valeurs stockées ? Si vous ne savez pas, lisez la javadoc !
Écrire la méthode toString. 

**Answer** : The method we can use to obtain all of the stored valued in our hash map, is `values`. Our hash map has
a structure of `"book title : Book Object"`, so a collection of values, would be the exact thing we need to implement the
`toString` method, and the `values` method of `java.util.HashMap` provides us with that. 
Here's the implementation of the `toString` method in this case : 
```java
@Override
public String toString() {
  var res = new StringBuilder();
  var separator = "";
  for(var value : books.values()) {
  	res.append(separator).append(value);
  	separator = ", ";
  }
  return res.toString();
}
```

6. En fait, la méthode toString ne fait pas exactement ce qui est demandé, car elle ne permet pas d'afficher les éléments dans l'ordre d'insertion. Sachant qu'il existe une classe LinkedHashMap, comment peut-on résoudre ce problème ? 

**Answer** : for this we could use a `LinkedHashMap` structures. This structure is different from HashMap in that it maintains a doubly-linked list kind of chain through all of its entries. This linked list defines the iteration ordering, which is usually the order in which keys were inserted into the map (insertion-order).
So we should a priori replace the `HashMap` with `LinkedHashMap` in the class. In order not to search manually for each
occurence to rename it, we procede in this way : press `Ctrl + F`, then in the appeared box, write HashMap in front of
`Find` field, and LinkedHashMap in front of `Replace With` field, then click on `Replace All` button.

7. On souhaite ajouter une méthode removeAllBooksFromAuthor qui prend un nom d'auteur en paramètre et supprime tous les livres de cet auteur de la bibliothèque.
Sachant qu'il existe une méthode remove dans la classe java.util.HashMap, écrire une implantation qui parcourt tous les livres avec une boucle for each et supprime ceux de l'auteur avec remove.
Pourquoi votre implantation lève-t-elle une exception dans l'exemple suivant ?
```java
  var library2 = new Library();
  library2.add(new Book("Da Vinci Code", "Dan Brown"));
  library2.add(new Book("Angels & Demons", "Dan Brown"));
  library2.removeAllBooksFromAuthor("Dan Brown");
```	  

**Answer** : The raised exception (`ConcurrentModificationException`) is there because we've attempted to modify a collection while iterating through it, using an iterator. This isn't allowed in Java because it can lead to undefined behavior and 
data corruption. Instead, we will use an `Iterator`, in the next question. Here's the code we've written,
who doesn't work :
```java
public void removeAllBooksFromAuthor(String author) {
  for(var book : books.values()) {
  	if(book.author().equals(author)) {
  	  books.remove(book.title());
  	}
  }
}
```

8. En fait, il existe une méthode remove sur l'interface Iterateur qui n'a pas ce problème, car le parcours et la suppression se font sur le même itérateur.
Implanter correctement la méthode removeAllBooksFromAuthor.

**Answer** : We should import `java.util.Iterator` at first.
```java
public void removeAllBooksFromAuthor(String author) {
  var iterator = books.values().iterator();
  while (iterator.hasNext()) {
  	var value = iterator.next();
  	if(value.author().equals(author)) {
  	  iterator.remove();
  	}
  }
}
```

9. Quelle est la complexité pire cas du code que vous avez écrit ?
Sachant qu'il existe une méthode removeIf sur Collection modifié le code de la méthode removeAllBooksFromAuthor.
Note: le code devrait s'écrire en une ligne ! 

**Answer** : The overall complexity of our method is dominated by the iteration over the collection (our Hash Map),
making it **`O(n)`**.
Here's a new `removeAllBooksFromAuthor` method who uses the `removeIf` method from the `Collection` interface to
remove all of the books associated to an author.
```java
public void removeAllBooksFromAuthor(String author) {
	books.values().removeIf((var book) -> book.author().equals(auhtor));
}
```
Details :

- `books.values()` returns a `Collection` of all book values in the `books` Hash Map. This is needed because
`removeIf()` is a method of the `Collection` interface.
- `.removeIf((var book) -> book.author().equals(author))` removes all books from this `Collection` where the
author of the book is equal to the `author` variable, given as an argument to our method.
- `(var book) -> book.author().equals(author)` is a lambda expression that defines the condition for removing
a book. It takes a book as input and returns `true` if the author of the book is equal to the `author` variable.
