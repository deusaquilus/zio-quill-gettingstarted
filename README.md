# ZIO-Quill Getting Started

This is a trivial example using ZIO-Quill with some helpful scripts to automatically setup a postgres database.
For a slighly more complete example try: [quill-examples-zymposium](https://github.com/kitlangton/quill-examples-zymposium).

## Instructions
1. Download and install docker.
2. Run the start script: `./start.sh`
3. Compile and run the examples: `sbt 'runMain example.Main'`
   ```
   > sbt 'runMain example.Main'
   List((Person(2,Vlad,Dracul,321),Address(2,Bran Castle,11111,Transylvania)), (Person(2,Vlad,Dracul,321),Address(2,Ambras Castle,11111,Innsbruck)))
   ```
4. Stop the container `./stop.sh`
