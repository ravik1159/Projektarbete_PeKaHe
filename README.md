# Projektarbete_PeKaHe

## Kontaktbok
Detta är en liten java-applikation (konsol) för att spara (söka, lista och ta bort) 
kontakter (namn och telefonnummer) i en textfil. Utvecklingen har gjorts som en
del av kursen Javaverktyg och Byggmiljöer på IT-Högskolan i Gbg med främsta syfte
att lära sig grunderna i JUnit, Maven, Jenkins och docker samt hur man bygger en 
robust applikation med bra felhantering.

## Bygga och köra
För att bygga och köra applikationen krävs Java 11/jdk 11 samt 
apache-maven-3.6.3 . Testerna körs med JUnit. 
För detaljer om plugins och versioner, se pom.xml.

1. Clona ner programmet till din disk.
2. Bygg i terminal med kommandot "mvn compile"
3. Kör programmet i IntelliJ, alternativt i terminalen med kommandot "mvn exec:java" 
   (förutsatt att exec-maven-plugin finns på plats, se pom.xml). 
   Om programmet paketerats till en .jar med kommandot "mvn package" kan det 
   startas med kommandot java -jar <sökväg>projektarbete_PeKaHe-1.0-SNAPSHOT.jar

## Feedback
Vi tar gärna emot feedback och förbättringsförslag!