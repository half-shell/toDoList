# TO-DO LIST

## CONCEPT

This application just consists of a simple to do list application which purpose is to be a CRUD, with
serialization eventually.

Design wise, it'll just contain an input text field at the bottom, with all the Todos above it.  Todos can be
edited and deleted, and be marked as TODO, or already done, so the user can get to see his progress.  All these
feature will have a visual return effect so javaFX can be exploited as intended.

## Maven
This project now supports maven. To get it running, install it via your favorite distribution package
manager, or get installation instructions on [their official website][maven install] and get it running by
doing a: 
``` 
mvn package
```
More on that [here][maven run]. 

In order for this to work, you'll have to have a working java setup (including javaFX), and maven installed.
Maven is supported by most of the IDEs out their, and you can can the package lifecycle through it.

## NEED TO-DO

* [ ]Add a delete/done feature
* [ ]Add serialization to data
* [ ]Add Tests
* [X]Enhance design and appearance

[maven run]: https://maven.apache.org/run.html
[maven install]: https://maven.apache.org/install.html
