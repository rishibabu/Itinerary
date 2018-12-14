# Project Title

Spring Boot Rest application to find the shortest path Itineraries from source to different destinations based on shortest time and connections,

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for dev.

### Prerequisites

Gradle runs on all major operating systems and requires only a Java Development Kit version 8 or higher to run. To check, run java -version. You should see something like this:

❯ java -version
java version "1.8.0_151"
Java(TM) SE Runtime Environment (build 1.8.0_151-b12)
Java HotSpot(TM) 64-Bit Server VM (build 25.151-b12, mixed mode)


### Installing

Installing manually
Step 1. Download the latest Gradle distribution from https://gradle.org/releases
The distribution ZIP file comes in two flavors:

Binary-only (bin)

Complete (all) with docs and sources


Step 2. Unpack the distribution


Microsoft Windows users
Create a new directory C:\Gradle with File Explorer.

Open a second File Explorer window and go to the directory where the Gradle distribution was downloaded. Double-click the ZIP archive to expose the content. Drag the content folder gradle-5.0 to your newly created C:\Gradle folder.


Step 3. Configure your system environment
For running Gradle, firstly add the environment variable GRADLE_HOME. This should point to the unpacked files from the Gradle website. Next add GRADLE_HOME/bin to your PATH environment variable. Usually, this is sufficient to run Gradle.

Microsoft Windows users
In File Explorer right-click on the This PC (or Computer) icon, then click Properties → Advanced System Settings → Environmental Variables.

Under System Variables select Path, then click Edit. Add an entry for C:\Gradle\gradle-5.0\bin. Click OK to save.

## Verifying installation

Explain how to run the automated tests for this system

Open a console (or a Windows command prompt) and run gradle -v to run gradle and display the version, e.g.:

❯ gradle -v

------------------------------------------------------------
Gradle 5.0
------------------------------------------------------------

Build time:   2018-02-21 15:28:42 UTC
Revision:     819e0059da49f469d3e9b2896dc4e72537c4847d

Groovy:       2.4.15
Ant:          Apache Ant(TM) version 1.9.9 compiled on February 2 2017
JVM:          1.8.0_151 (Oracle Corporation 25.151-b12)
OS:           Mac OS X 10.13.3 x86_64




## Deployment

Since it is a mircroservice navigate to each project folder separately using cmd and  type * **bootRun** on each cmd line window and navigate to * **http://localhost:8100/swagger-ui.html**



## Authors

* **Rishi Babu** 


