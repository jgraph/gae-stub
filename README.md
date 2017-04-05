# gae-stub
Stub library for Google App Engine calls used in draw.io

Maven hosted version at https://packagecloud.io/jgraph/gae-stub

Before building ensure PACKAGECLOUD_TOKEN is defined in your environment, e.g. export PACKAGECLOUD_TOKEN=xxxxxxxxxxxxxxxxx in .bash_profile.

In ~/.m2/settings.xml either add or append

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      http://maven.apache.org/xsd/settings-1.0.0.xsd">
  <servers>
    <server>
      <id>packagecloud-jgraph</id>
      <password>${env.PACKAGECLOUD_TOKEN}</password>
    </server>
  </servers>
</settings>
```

Build the package using:

`mvn package`

Deploy to Packagecloud using:

`mvn deploy`

Note : You must manually change the version in the POM and tag the git repo when performing a release.
