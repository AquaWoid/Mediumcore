# Mediumcore
Mediumcore allows for a customizable semi-hardcore server experience.
The generated config.yml lets you configure a life amount as well as a ban duration.
If a player dies x times (default = 3) they will get automatically banned for x hours (default = 24) 

The latest working plugin file can be found on the releases page.
---
# Install and Usage for Server Owners

1. If running, stop the server.
2. Copy the packaged plugin into your servers "plugins" folder.
3. Start the server, when succesfully loaded the plugin will create a folder called "mediumcore" inside the plugins folder.
4. Adjust the config.yml in the mediumcore folder to your liking.
5. Restart the server to apply config changes. 

---
# Info for building from source

The plugin was written in IntelliJ Idea Community
Build dependencies:
- OpenJDK 21
- Maven 3.9.9
- Spigot-API 1.21.8-R0.1-SNAPSHOT
