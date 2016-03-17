# TO-DO APPLICATION SPECS

## KNOWLEDGE

  * Javafx integration

## Maven
This project now supports maven. To get it running, install it via your favorite distribution package manager, or get installation instructions on [their official website][maven install] and get it running by doing a:
'''
mvn package
'''
More on that [here][maven run].
In order for this to work, you'll have to have a working java setup (including javaFX), and maven installed.
It'll run tests, and build the project if it passes the latter.

## NEED TO-DO

### Task definition
* Add a delete/done feature
* Add serialization to data
* Enhance design and appearance

## CONCEPT

This application just consists of a simple to do list application which purpose is to be a CRUD, with serialization.

Design wise, it'll just contain an input text field at the bottom, with all the Todos above it. 
Todos can be edited and deleted, and be marked as TODO, or already done, so the user can get to see his progress.
All these feature will have a visual return effect so javaFX can be exploited as intended.

## SYMBOLIC RELEASES

* Getting the GUI up and running (Almost done)
* Finished the base CRUD
* All done and beautifully beautiful

[maven run]: https://maven.apache.org/run.html
[maven install]: https://maven.apache.org/install.html
