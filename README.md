# Data Structures and Algorithms
Data Structures and algorithms in C, C++, C#, Java, and Python 

## Modules
0. [Recursions and generics](./mod0/README.md)
   1. Recursions
   2. Interfaces
   3. Generics
1. [Linear Data Structures](./mod1/README.md)
   1. Lists, Stacks, Queues, and Priority Queues
   2. Sets and Maps
   3. Hashing
2. [Developing Efficient Algorithms](./mod2/README.md)
   1. Sorting
   2. Implementing Lists, Stacks, Queues, and Priority Queues
3. [Trees](./mod3/README.md)
   1. Binary Search Trees
   2. AVL Trees
   3. 2-4 trees and B trees
   4. red-black trees
4.  [Graphs](./mod4/README.md)
    1.  Graphs and Applications
    2.  Weighted Graphs and Applications
5.  [Aggregate Operations for Collection Streams](./mod5/README.md)
6.  [Implemented data structures and algorithms](./mod6/README.md)
    1.  Java collection framework
    2.  C# collections
    3.  C++ standard templates



## [Setup JDK and IDE](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/#software)
1. Download and install [Java JDK FX 11 (LTS) ](https://www.azul.com/downloads/?version=java-11-lts&os=windows&architecture=x86-64-bit&package=jdk) following the [instructions](https://docs.azul.com/core/zulu-openjdk/install/windows). **Note: Choose JDK FX**
   1. Choose install all features on local hard drive during the installation
2. Download and install IDE
   1. Download and install the system installer of [Visual Studio Code](https://code.visualstudio.com/) **Recommended!**
      1. Tick all selection square boxes during the installation
      2. Install [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
      3. [demo video](https://youtu.be/oWIGI9AUYqU)
   2. _optional IDE_
      1. Download and install [Apache Netbeans](https://netbeans.apache.org/)
      2. Download and install [Eclipse](https://www.eclipse.org/downloads/)
      3. Download and install [InteliJ IDEA](https://www.jetbrains.com/idea/)
3. IDE startup
   1. [Netbeans startup instructions](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_11/cw/content/supplements/Supplement2dNetBeansStartup.pdf)
   2. [Eclipse Startup Instructions](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_11/cw/content/supplements/Supplement2fEclipseStartup.pdf)


## Clean installation
If you have other Java JDK or old Visual Studio code polluted your system rendering you unable to run JavaFX programs, you may clean them as below:

- Clean Visual studio code
  - Uninstall visual studio code
    - delete the Code folder inside folder "%userprofile%\AppData\Roaming"
    - delete folder "%userprofile%\\.vscode"
    - for example, on Mike's computer:
    ```
     1. Go to where Visual Studio Code is installed and invoke 'uninst000.exe'. In Mike's case it is installed in C:\Users\Mike\AppData\Local\Programs\Microsoft VS Code
     2. Delete directory C:\Users\Mike\AppData\Roaming\Code
     3. Delete directory C:\Users\Mike\.vscode
    ```
- Clean JDK
  - Uninstall any JDK or JRE from your system
   - delete JAVA_HOME environment variable
   - delete any value contains java in your user and system PATH variables

Now you have a clean environment. Follow the [demo video](https://youtu.be/oWIGI9AUYqU) to reinstall JDK FX and Visual Studio Code.

## Reference textbooks and classes
* [Introduction to Java Programming, Comprehensive, 12/E](https://media.pearsoncmg.com/bc/abp/cs-resources/products/product.html#product,isbn=0136519350)
  * [Student resources](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/)
  * [Source code](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/content/source-code.php)
* [Foundations of Algorithms 5th](https://www.jblearning.com/catalog/productdetails/9781284049190)
* [10 Best Data Structures and Algorithms Books](https://www.interviewbit.com/blog/data-structures-and-algorithms-books/)
  * [Introduction to Algorithms, Fourth Edition](https://mitpress.mit.edu/books/introduction-algorithms-fourth-edition)
    * [Introduction to Algorithms 6.006](https://github.com/MahmoudAbdelazim/MIT-Algorithms-6.006)
    * [Solutions to CLRS](https://github.com/gzc/CLRS)
    * [Problem Sets](https://github.com/avhn/MIT6006)
  * [Algorithms, 4th Edition](https://algs4.cs.princeton.edu/home/)
    * [source code](https://github.com/kevin-wayne/algs4)
  * [Data Structures and Algorithm Analysis in C++, 4th Edition](https://www.pearson.com/us/higher-education/program/Weiss-Data-Structures-and-Algorithm-Analysis-in-C-4th-Edition/PGM148299.html)
    * [author website](http://users.cs.fiu.edu/~weiss/)
  * [Data Structures and Algorithm Analysis in Java, 3rd Edition](https://www.pearson.com/us/higher-education/program/Weiss-Data-Structures-and-Algorithm-Analysis-in-Java-3rd-Edition/PGM324443.html)
  * [Introduction to Python Programming and Data Structures](https://www.pearson.com/us/higher-education/program/Liang-Revel-for-Introduction-to-Python-Programming-and-Data-Structures-Access-Card/PGM2473207.html)
* [Top 10 Free Data Structure and Algorithms Courses for Beginners — Best of Lot](https://medium.com/javarevisited/top-10-free-data-structure-and-algorithms-courses-for-beginners-best-of-lot-ad807cc55f7a)
* [Stanford Computer Science](https://www.classcentral.com/list/stanford-pgqmp1a2b89)
  * [CS161 Design and Analysis of Algorithms Winter 2022](https://stanford-cs161.github.io/winter2022/schedule/)
    * [code 2020](https://github.com/suhassrivats/Stanford-Data-Structures-and-Algorithms)
    * [Fall 2017](http://web.stanford.edu/class/archive/cs/cs161/cs161.1182/index.html)
  * [CS166 Data Structures](http://web.stanford.edu/class/cs166/)


## Online resources
* _Wikipedia_
  * [List of data structures](https://en.wikipedia.org/wiki/List_of_data_structures)
  * [List of algorithms](https://en.wikipedia.org/wiki/List_of_algorithms)
* _Algorithm visualization_
  * [visualgo - visualize algorithms](https://visualgo.net/)
  * [Liang animation](https://liveexample.pearsoncmg.com/liang/animation/animation.html)
  * [Visualize code execution](https://pythontutor.com/)
  * [Data Structure Visualizations](https://www.cs.usfca.edu/~galles/visualization/Algorithms.html)
  * [Algovis](https://chiranjeevikarthik.me/Algovis/)
    * [source code](https://github.com/karthikchiru12/Algovis)
  * [Algovis.io](https://tobinatore.github.io/algovis/index.html)
    * [source code](https://github.com/hotshot07/algovis)
  * [visualgo](https://visualgo.net/en)
  * [CS1332 Data Structures and Algorithms Visualizations](https://csvistool.com/)
  * [Algorithm Tutor](https://algorithmtutor.com/)
  * [kalkicode](https://kalkicode.com/)
  * [Linked list visualization](https://antoniosarosi.github.io/Linked-List-Visualization/)
* _online tools_
  * [Graph editor](https://csacademy.com/app/graph_editor/)
  * [Graph online](https://graphonline.ru/en/)
* _Java_
  * [OpenJDK 17 Documentation](https://devdocs.io/openjdk~17/)
    * [OpenJDK 11.0.11 Documentation](https://devdocs.io/openjdk~11/)
  * [Package java.util](https://devdocs.io/openjdk~17/java.base/java/util/package-summary)
    * [The Collections Framework](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/doc-files/coll-index.html)
    * [Trail: Collections](https://docs.oracle.com/javase/tutorial/collections/index.html)
  * [Algorithms in Java](https://github.com/williamfiset/Algorithms)
* _C++_
  * [boost](https://www.boost.org/)
