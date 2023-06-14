# VocabularyApp
An application written in Java and ran in Netbeans, created to help optimize the process of learning vocabulary. Features of the application include: adding new English words, getting a suggested Vietnamese meaning of the entered English word by an Eng-Viet translation API, studying flashcards created in two language modes Eng-Viet or Viet-Eng and testing your progress by taking quizzes in both languages mode.
Main Menu Window:

<img width="590" alt="image" src="https://user-images.githubusercontent.com/39193084/168049858-a7541d4d-0014-48ee-b7c8-39288c9ee844.png">
1. Demonstration of inputing a new ENglish word, fetching its suggested dictionary meaning and store it into saved items:

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

### 1. Word input storage Data structure & Presentation
  
    **ArrayLists**  
    
    I used an ArrayList called keysArrayList to store the English representation of every word as String, which is the “key” to differentiate between Word objects. This is used to retreive such Word object from the dictionary (which is a HashMap collection). ArrayLists were chosen instead of other datatypes such as LinkedLists since ArrayList is a dynamically resizable array which allows efficiency of O(1) when stored data is accessed, consumes less memory than its counterparts. This means that regardless of the set size, the amount of time spent accessing data remains constant, which is particularly helpful for storing a large number of word inputs. Furthermore, using ArrayLists facilitates storing data in a dedicated manner, making future updates to the list straightforward.  

    **HashMap collection (Objects as data records)**  

    A HashMap is created to store the String and Word pairs, effectively pairing the English word string - the “key”, to the Word object itself. Therefore, we can retrieve a Word object knowing its English representation, avoiding assigning numerical indexes which can complicate the process of updating and accessing the Word objects.  

    **Abstract TableModel**  

    The table view of all saved items is constructed based on an Abstract TableModel class, which does not need to be instantiated for its object data to be accessed. Columns and rows of the table view are filled as this TableModel retrieved values from the aforementioned ArrayList that reads all the English-word keys (of the HashMap function) and their corresponding properties in Word objects. By modifying data of the Abstract TableModel, the table view is accordingly and instantaneously updated, with the use of a TableModel listener. The Delete Word and Edit Word features refer to this class and make changes to its data, while simulataneously updating the HashMap function that is the saved dictionary. Abstract TableModel is chosen over Default TableModel as it provides a convenient class that can extend to a model.  






## DESIGN:  
 
### 1. Hierarchical Chart  
Represents how different windows and interfaces for each feature are linked together  



### 2. Data Flow Diagram  
Highlights the process of data flowing through the system when the program is running. This also shows the internal workings of the program as multiple commands write and read data.  

### 3. GUI elements  

*Figure 1*: Main Menu Window  

*Figure 2*: Input new word Window  

*Figure 3*: View saved words Window  

*Figure 4*: Flashcard Window  

*Figure 5*: Quiz Window – Mode English-Vietnamese  

*Figure 6*: Quiz Window – Mode Vietnamese-English  

### 4. Flowchart  
Represents the processes running when the user interacts with the application and portrays how its different features work in tandem.


### 5. Key algorithms  

**Generate a random Question and its multiple choices**


**Calculate score of a quiz**


**Randomize a set of flashcards**


### 6. UML Diagram


### 7. Data dictionary