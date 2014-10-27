Search Engine Project Version 1
-------------------------------


This is a somewhat fancy version of SearchEngine that 
does what's needed for the first iteration, but also plans
a bit for the future.

Project Files
-------------

.project

> This is a normally hidden file, but essential if you
> clone/download the project and would like to import into
> Eclipse. Just File -> Import -> General -> Existing Java   
> Project 

> Notice please that all java files are in the package 
> org.uiowa.cs2820.engine

Field.java

> This is the Field class, which users will use to index
> and search for content. Each Field object has two components,
> a field name (like "Color", "Part", "Title", etc) and an
> associated value.  Since a value could be a string, a number,
> or something more complex like an array or object, we need
> a universal way for the value to be anything. This is done by
> converting the data into a byte array:  standard Java library  
> methods convert anything into a byte array. i

> The Field constructor converts the type of the value into a
> byte array (class method "convert" does this). Two "getter" 
> methods return the field name and field value for a Field 
> object.            

> The advantage of using a byte array for a field value is that
> it can be any kind of object.  Similarly, we might consider
> converting a Field object itself into a byte array:  this would
> be useful in some future scenarious if we plan to save Field 
> objects to a file or something like that.  The "toBytes" method
> returns a byte array representing both field name and field value, 
> which is used by Indexers and FieldSearch instances for some 
> lookups.

Node.java

> Nodes are the vertices of trees (or lists, arrays, etc) that 
> hold the data for lookup. The Database creates nodes, copies 
> data into nodes, stores the nodes for later operations.
> FieldSearch also needs to know about nodes for lookup
> operations.  Each node has two parts, a key and an associated
> list of identifiers.  The idea is that a lookup finds content
> by key; the list of identifiers is then enough to satisfy the 
> user's query.  

> The constructor expects a key and an identifier: new nodes 
> have only one identifier (a string), and the key is a byte
> array. The "add" method adds a new identifier to a node's 
> list of identifiers. The "del" method removes an identifier
> from the list. 

Indexer.java

> The Indexer is simple: it stores data from a Field object 
> into the Database, calling the database "store" method. The 
> idea of an Indexer is that is may get called many times on
> behalf of one file, or even one line in a file.  It's the 
> file name, or the line number, that needs to be remembered
> later so that a query tells the user the location of the 
> content. Therefore, the identifier (file name, line number) 
> is a string that is saved by Indexer's constructor.

FieldSeach.java

> The FieldSearch class is very simple; in fact, it is far 
> too simple when thinking about future enhancements to the 
> project.  Currently there is only one kind of search, find
> all the locations where a specified Field object is found.

Database.java

> Unlike the other files, this one's not a class. Database is 
> an interface, which just has the methods for working with 
> the persistent storage.  What's perhaps interesting to learn
> is that an interface type can be used to type a variable, 
> and that is what Indexer and FieldSearch do: they have a variable
> of type Database that is set in the constructor. Conceptually, 
> there is only one Database, so it could be a class (static) 
> implementation rather than instance-based; we're using an 
> instance-based implementation because it offers a bit more 
> flexibility for unit testing. 

LinearMemoryDatabase.java

> This class implements the Database interface in memory, 
> with a simple ArrayList of Nodes. Search and update is 
> by brute-force iteration to find a Node with the desired
> key.  

FieldTest.java

> The integration test for all classes above. 
