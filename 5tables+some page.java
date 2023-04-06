        tableStruct.put("Book", "(ISBN VARCHAR(255) not NULL, " +   
                                    " Title VARCHAR(255), " + 
                                    " Authors VARCHAR(255), " + 
                                    " Price INTEGER, " + 
                                    " InventoryQuantity INTEGER, " +
                                    " PRIMARY KEY ( ISBN ))");
        tableStruct.put("Customer", "(UID VARCHAR(255) not NULL, " +   
                                        " first VARCHAR(255), " + 
                                        " last VARCHAR(255), " + 
                                        " age INTEGER, " + 
                                        " Address VARCHAR(255), " +
                                        " PRIMARY KEY ( UID ))");
        tableStruct.put("Ordering", "(OID VARCHAR(255) not NULL, " +   
                                        " OrderISBN VARCHAR(255) not NULL, " +
                                        " UID VARCHAR(255), " + 
                                        " OrderDate VARCHAR(255), " + 
                                        " OrderQuantity INTEGER, " + 
                                        "ShippingStatus VARCHAR(255),"
                                        " PRIMARY KEY ( OID, OrderISBN ))");
        tableStruct.put("Cart", "(OID VARCHAR(255) not NULL, " +   
                                    " OrderISBN VARCHAR(255), " + 
                                    " UID VARCHAR(255), " + 
                                    " PRIMARY KEY ( OID, OrderISBN , UID ))");
        tableStruct.put("Package", "(OID VARCHAR(255) not NULL, " +   
                                    " OrderISBN VARCHAR(255), " + 
                                    " ISBN VARCHAR(255), " + 
                                       " PRIMARY KEY ( OID, OrderISBN, ISBN ))");

book_search(){ //page 2 case 1
string find_isbn = null ;
string find_title = null ;
string find_author = null;
Scanner myObj = new Scanner(System.in);  
System.out.println("Search by ISBN press 1; Search by Title press 2; Search by Author press 3: ");

String search_type = myObj.nextLine();

if (search_type == 1) {
System.out.println("The ISBN of the book is:");
String search_ISBN = myObj.nextLine();


EXEC SQL DECLARE Search CURSOR FOR
SELECT
FROM Book
WHERE ISBN = search_ISBN;
EXEC SQL OPEN Search;
if (Search != void) {System.out.println("The information of the book are:" Search);
else {System.out.println("Book not found")}
}

else if (search_type == 2) {
System.out.println("The title of the book is:");
String search_title = myObj.nextLine();


DECLARE Search CURSOR FOR
SELECT
FROM Book
WHERE Title = search_title;
EXEC SQL OPEN Search;
if (Search != void) {System.out.println("The information of the book are:" Search);
else {System.out.println("Book not found")}
}

else if (search_type == 1) {
System.out.println("The authors of the book is:");
String search_author = myObj.nextLine();


DECLARE Search CURSOR FOR
SELECT
FROM Book
WHERE Authors = search_author;
EXEC SQL OPEN Search;
if (Search != void) {System.out.println("The information of the book are:" Search);
else {System.out.println("Book not found")}
}

else {System.out.println("Please enter 1, 2, or 3.");}
}


order(){ //page 2 case 2
// idk how this part work
}


checkorder(){ //page 2 case 3
	Scanner myObj = new Scanner(System.in);  

	System.out.println("Please enter your UID:");
	String uid = myObj.nextLine();

DECLARE SearchUID CURSOR FOR
SELECT
FROM Order
WHERE UID = uid;
EXEC SQL OPEN SearchUID;
System.out.println("The information of your booking are:" SearchUID)
}

