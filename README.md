# Vocabulary-App
An application written in Java, used Java Swing and demo-ran in Netbeans, created to help optimize the process of learning vocabulary. Features of the application include: adding new English words, getting a suggested Vietnamese meaning of the entered English word via an Eng-Viet translation API, studying flashcards created in two language modes Eng-Viet or Viet-Eng, and testing your progress by taking quizzes, also available in both language modes.  

Main Menu Window:

<img width="590" alt="image" src="https://user-images.githubusercontent.com/39193084/168049858-a7541d4d-0014-48ee-b7c8-39288c9ee844.png">

1. Demonstration of inputing a new English word, fetching its suggested dictionary meaning and store it into saved items:

![demo](https://user-images.githubusercontent.com/39193084/168065396-2cf2db68-1f91-478d-9c19-512b85afbb07.gif)

2. Edit/delete or search for an item in the saved words list:

![demo saved words](https://user-images.githubusercontent.com/39193084/168063387-c7f1c857-d6a2-4437-a426-b5c5692c3403.gif)

3. Studying new words by using flashcards, easily switching between two language modes:

![Screen Recording 2022-05-12 at 19 24 35](https://user-images.githubusercontent.com/39193084/168064640-51812c45-1459-495f-9a4b-39197215e0ee.gif)

4. Taking quizzes to test your vocabulary. Choose the number of words you want to be tested in a quiz, in Eng-Viet mode or Viet-Eng mode:

![Screen Recording 2022-05-12 at 19 25 47](https://user-images.githubusercontent.com/39193084/168064738-63adb420-fe84-4397-80cb-7f49e291a7ce.gif)

![Screen Recording 2022-05-12 at 19 27 02](https://user-images.githubusercontent.com/39193084/168064833-33e38ba9-02b7-41ee-a6de-028560f8de53.gif)

5. Export your saved items into a .csv file that can easily be used in another application/website!  

# Documentation  

## DEVELOPMENT:  

### Complexities:  
-	Encapsulation  
-	Abstraction  
-	File Handling  
-	Arrays  
-	Inheritance  
-	Complex Selection  
-	Objects as data records  
-	Loops  
-	HashMap collections  
-	Use of flags  
-	Use of additional libraries (JSON)

### IDE & Java libraries used

Netbeans was used. JavaSwing GUI libraries are utilized to design how different GUI windows interact. Accessing translated Vietnamese meaning of an entered English word by retrieving the JSON response object from online API dictionary and converting the object to text with JSON libraries.  

<img width="493" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/bed6d376-fdd0-4926-baae-c2c43d4d3c0c">

*Figure 1: Parsing the required translation text from JSON response object*  
&nbsp;
&nbsp;

### 1. Word input storage Data structure & Presentation
  
&nbsp; &nbsp; **ArrayLists**  

&nbsp; <img width="447" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/85f51fd6-084c-4ff9-ad04-19c2952bdc5b">  
&nbsp; *Figure 2: An ArrayList storing English property as the key to identify Word objects*  

      
&nbsp; I used an ArrayList called keysArrayList to store the English representation of every word as String, which is the “key” to differentiate between Word objects. This is used to retreive such Word object from the dictionary (which is a HashMap collection). ArrayLists were chosen instead of other datatypes such as LinkedLists since ArrayList is a dynamically resizable array which allows efficiency of O(1) when stored data is accessed, consumes less memory than its counterparts. This means that regardless of the set size, the amount of time spent accessing data remains constant, which is particularly helpful for storing a large number of word inputs. Furthermore, using ArrayLists facilitates storing data in a dedicated manner, making future updates to the list straightforward.  
&nbsp;
&nbsp;

&nbsp; &nbsp; **HashMap collection (Objects as data records)**  

&nbsp; <img width="331" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/05d6d61b-1612-4d3c-9244-90c7f7b3af57">  
&nbsp; *Figure 3: Dictionary HashMap creation*  
  

&nbsp; A HashMap is created to store the String and Word pairs, effectively pairing the English word string - the “key”, to the Word object itself. Therefore, we can retrieve a Word object knowing its English representation, avoiding assigning numerical indexes which can complicate the process of updating and accessing the Word objects.  
&nbsp;
&nbsp;

&nbsp; &nbsp; **Abstract TableModel**  

&nbsp; <img width="489" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/bd25995c-01f6-4d37-aae2-da3ccb2c3ca0">  
&nbsp; *Figure 4: Constructing a table of saved words by getting Word objects’ properties in TableModel class*  

  
&nbsp; The table view of all saved items is constructed based on an Abstract TableModel class, which does not need to be instantiated for its object data to be accessed. Columns and rows of the table view are filled as this TableModel retrieved values from the aforementioned ArrayList that reads all the English-word keys (of the HashMap function) and their corresponding properties in Word objects. By modifying data of the Abstract TableModel, the table view is accordingly and instantaneously updated, with the use of a TableModel listener. The Delete Word and Edit Word features refer to this class and make changes to its data, while simulataneously updating the HashMap function that is the saved dictionary. Abstract TableModel is chosen over Default TableModel as it provides a convenient class that can extend to a model.  
&nbsp;
&nbsp;
  
&nbsp; &nbsp; **Edit a selected word**

&nbsp; <img width="489" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/aec8aca9-d138-4a27-8a52-5455b7d4c52b">  
&nbsp; *Figure 5: Method to edit a selected word*  


&nbsp; By accessing a Word object through its English key, user can make change to its other properties: the updated values are input through a JOptionPane. Creating a new Word object with these edited properties and retrieving the old Word object in the HashMap collection, I replace it with the new Word object, so that the dictionary is updated. Meanwhile, this word’s element in the TableModel is also modified, hence the table view is updated instantaneously.  
&nbsp;
&nbsp;

&nbsp; &nbsp; **Search word by RowSorter**

&nbsp; <img width="322" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/f0ad7ec9-9a33-454e-9126-7be8dd89b73d">  
&nbsp; *Figure 6: Search word by RowSorter*  

&nbsp; By retrieving the user input of a word to search for from the engWordToSearch field, all saved items are filtered to match the input using RowSorter, a JavaSwing built-in method of filtering. The list of filtered items are updated everytime an additional letter is keyed; single-selection of word is enabled within this filtered list.  
&nbsp;
&nbsp;

### 2. Encapsulation  

<img width="437" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/99fd7fa2-b75f-46d3-b441-51c29f389bdc">

*Figure 7: The class of Word utilizing encapsulation (OOP)*  


Encapsulation is used throughout the program to ensure that variables created are not inadvertently accessible by another class. Other objects cannot affect the internal state of encapsulated objects.  
&nbsp;
&nbsp;

### 3. Question class  

<img width="364" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/f8f5ab24-556c-4ea2-9918-2214eb7974fa">

*Figure 8: Properties of Question class*  


The Question class, inherited by Flashcard and Quiz class, is constructed to facilitate the use of Word objects in creating flashcards & quizzes. Question extends a Word object by including properties such as an array MCQ options, which are retrieved from English/Vietnamese meaning of other random words. This is achieved by methods of randomizing a set of numbers. There is also method to check if an option (String value) corresponds with the correct English/Vietnames meaning of the word in that Question object.  
&nbsp;
&nbsp;

&nbsp; &nbsp; **Random set of unique numbers**  

&nbsp; <img width="472" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/085f5b1f-a43e-413b-a1b6-1730ea56ca34">  
&nbsp; *Figure 9: Method to geenrate a set of random unique numbers*


&nbsp; A set of numbers within the range of the dictionary size is randomized by Java built-in Collections feature. These numbers then are used as indexes to retrieve Question objects from an ArrayList in a non-orderly manner, to shuffle the words used for flashcards and quizzes.  
&nbsp;
&nbsp;

### 4. Flashcards (Inheritance)  

<img width="335" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/6d568d85-f166-46fb-bb4b-7c834dd0a0d0">

*Figure 10: Flashcard class Constructor*


An ArrayList of Question objects is used to store properties of all Word objects in the dictionary for the application to read from. A set of flashcards is generated when there is at least 4 words stored in the dictionary of the program. By using a while loop to iterate through the generateCard method to ensure all words are included in the Questions ArrayList.  
&nbsp;
&nbsp;

&nbsp; &nbsp; **For loop**  

&nbsp; <img width="489" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/2a1b0bcf-2a33-4c12-9b2e-3e2cd8c01c09">  
&nbsp; *Figure 11: Method to check for unique element in Question ArrayList*


&nbsp; I implemented a for loop to check if elements in the Questions ArrayList are duplicated, so that the flashcards generated from this ArrayList presented to user are not repeated, until a cycle of all the words in the dictionary is shown (used in tandem with a Flashcard counter)  
  

&nbsp; <img width="385" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/b50a19e8-0992-41c5-b10d-e467d24e6b03">  
&nbsp; *Figure 12: Flashcard counter flashCount in GUI class*
&nbsp;
&nbsp;

### 5. Quiz (Inheritance)  

<img width="513" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/bee7f376-453e-4144-afbd-a5db17a3b2c2">

*Figure 13: Methods to calculate score for 2 different language modes*  


The Quiz class comprises a Question ArrayList of equal size to the number of questions chosen by user. There are 2 language modes in Quiz feature, English-Vietnamese and Vietnamese -English, so there are 2 sets of options, in 2 languages, which would be counterpart to the language of the question present, matching the mode choice. Display quiz options based on the ArrayList of 4 options (vietOptionsArrayList or engOptionsArrayList) that is a property of the Question object. There is a method to calculate score of Quiz by storing all selected options in an ArrayList and using method in Question class to check if they match the correct answer.  
&nbsp;
&nbsp;

### 6. Mode switching (Complex Selection)  

<img width="378" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/35666f9d-35cd-485e-9f13-39f500da45e0">

*Figure 14: Switching to VietQuiz window based on mode selected*


2 different language modes are separate into 2 different windows in the Quiz feature that switch on command of a ComboBox Listener. However, switching mode in Flashcard feature simply switches the order to which the 2 sides appear and reveal.
&nbsp;
&nbsp;

<img width="489" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/2e981338-e7aa-49f7-8230-af1c8a10d629">

*Figure 15: Different order of flashcard sides to appear and to be revealed in 2 modes*  


### 7. File Handling  

<img width="506" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/2ed8c3db-1bec-4647-b2f9-8cb42ad69cfe">

*Figure 16: Writing data to local dictionary.dat file*  


To utilize the HashMap that stores pairs of English key and Word object, the program should be able to write to a local file to save the inputs without data loss across multiple relaunches. The FileKeep class creates an editable file in the local folder “dictionary.dat” and store values from the dictionary when application is closed. As application reopens, this file is read, and data is imported into the HashMap dictionary.  
&nbsp;
&nbsp;

## DESIGN:  
 
### 1. Hierarchical Chart  
Represents how different windows and interfaces for each feature are linked together  

<img width="523" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/e2f404df-95d0-4e0f-a192-ab4fa30a7131">
&nbsp;
&nbsp;

### 2. Data Flow Diagram  
Highlights the process of data flowing through the system when the program is running. This also shows the internal workings of the program as multiple commands write and read data.  

<img width="470" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/20e8c0ab-2d7d-435f-b8ce-be87bc37c3d6">
&nbsp;
&nbsp;

### 3. GUI elements  

<img width="656" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/f8d5d871-e9f7-487a-a21c-71dc0bc97fce">  

*Figure 1*: Main Menu Window  
&nbsp;
&nbsp;

<img width="674" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/37dd184f-ac6e-4d14-8c83-eaee92113677">  

*Figure 2*: Input new word Window  
&nbsp;
&nbsp;
  
<img width="655" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/1a5a3c22-c2db-4777-b2db-9d935935de83">  

*Figure 3*: View saved words Window  
&nbsp;
&nbsp;

<img width="671" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/64648ed8-529c-46b1-8354-b86fadaa2543">  

*Figure 4*: Flashcard Window  
&nbsp;
&nbsp;

<img width="652" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/fbb95640-a093-468d-b66e-47d75f4a2525">  

*Figure 5*: Quiz Window – Mode English-Vietnamese  
&nbsp;
&nbsp;

<img width="651" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/2f8b6d62-f0fc-46d9-8915-506efd83c405">  

*Figure 6*: Quiz Window – Mode Vietnamese-English  
&nbsp;
&nbsp;

### 4. Flowchart  
Represents the processes running when the user interacts with the application and portrays how its different features work in tandem.  

![image](https://github.com/michelleln/Vocabulary-App/assets/133190574/56c50008-eb68-44fe-a2e8-3c103de11676)
&nbsp;
&nbsp;

### 5. Key algorithms  

**Generate a random Question and its multiple choices**  
<p align="center"><img width="89" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/eadecf9e-86f5-49d0-850b-f12e20c7b3d4"></p>  
  
&nbsp;
&nbsp;
  
**Calculate score of a quiz**  
<p align="center"><img width="176" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/b54f67a8-f198-41a0-8ae1-88c24c02e073"></p>  
  
&nbsp;
&nbsp;
  
**Randomize a set of flashcards**  
<p align="center"><img width="184" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/5bd9a371-6ead-4592-b957-ede1c5f5ca9a"></p>  
  
&nbsp;
&nbsp;
  
### 6. UML Diagram  

<p align="center"><img width="522" alt="image" src="https://github.com/michelleln/Vocabulary-App/assets/133190574/6361156a-b482-42bf-a84d-26c8755780bf"></p>


### 7. Data dictionary  

| Fields | Data Types | Constraints | Example |
| ----------- | ----------- | ----------- | ----------- |
| English word | String | Not null | “apple” |
| Suggested meaning | String | | “táo” |
| Your own definition | String | | “quả táo” |
| Words in context | String | | “I have an apple” |
| Additional notes | String | | "" |
