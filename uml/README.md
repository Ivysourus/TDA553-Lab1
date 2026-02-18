# PlantUML files
## Generation
Run the following command to generate the `.puml` files from source:
```bash
mvn de.elnarion.maven:plantuml-generator-maven-plugin:generate
```
## Rendering
Run the following command in this directory to render
the diagrams to svg files inside the `rendered` directory:
```bash
plantuml -o rendered -tsvg .
```
