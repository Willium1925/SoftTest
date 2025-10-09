1. pom 需添加
~~~xml
    <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- https://mvnrepository.com/artifact/net.sourceforge.pmd/pmd-java -->
        <dependency>
            <groupId>net.sourceforge.pmd</groupId>
            <artifactId>pmd-java</artifactId>
            <version>7.10.0</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-pmd-plugin</artifactId>
                <version>3.25.0</version>
                <configuration>
                    <rulesets>
                        <!-- 臭味放在這 -->
                        <ruleset>src/main/resources/rule_set.xml</ruleset>
                    </rulesets>

                    <format>html</format> <!-- or "html", "text", "plain", etc. -->


                    <!-- ture will cause building fail if violate -->
                    <failOnViolation>false</failOnViolation>

                    <!-- 1 is the most critical violation;
                         1: critical; 2: major; 3: normal;
                         4: minor; 5: information
                         if you set 5, the report will show all violations
                    -->
                    <minimumPriority> 3 </minimumPriority>
                </configuration>
                <executions>
                    <execution>
                        <phase> verify </phase>
                        <goals>
                            <goal>check</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>

        </plugins>
    </build>
~~~

2. 根據上述設定配置，需添加檔案 rule_set.xml
~~~xml
<?xml version="1.0" encoding="UTF-8"?>

<ruleset name="All Java Rules"
         xmlns="http://pmd.sourceforge.net/ruleset/2.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://pmd.sourceforge.net/ruleset/2.0.0 https://pmd.sourceforge.io/ruleset_2_0_0.xsd">
    <description>Every Java Rule in PMD</description>

    <!-- exclude the checking of all files in xdemo   -->
    <!--    <exclude-pattern>.*[/\\]xdemo[/\\].*\.java</exclude-pattern>-->

    <!--    the rules to be checked 想要檢查的規則-->
    <rule ref="category/java/bestpractices.xml">
        <exclude name="SystemPrintln"/> <!-- 這當中我不要的規則就這樣寫 -->
        <exclude name="AvoidReassigningParameters"/>
    </rule>
    <rule ref="category/java/codestyle.xml">
    </rule>
    <rule ref="category/java/design.xml" />
    <rule ref="category/java/documentation.xml" />
    <rule ref="category/java/errorprone.xml" />
    <rule ref="category/java/multithreading.xml" />
    <rule ref="category/java/performance.xml" />
    <rule ref="category/java/security.xml" />

    <!--  override the rules  -->
    <rule ref="category/java/documentation.xml/CommentSize">
        <properties>
            <property name="maxLines" value="6" />
            <property name="maxLineLength" value="80" />
        </properties>
    </rule>

    <rule ref="category/java/documentation.xml/CommentRequired">
        <properties>
            <property name="methodWithOverrideCommentRequirement" value="Ignored" />
            <property name="accessorCommentRequirement" value="Ignored" />
            <property name="classCommentRequirement" value="Required" />
            <property name="fieldCommentRequirement" value="Ignored" />
            <property name="publicMethodCommentRequirement" value="Required" />
            <property name="protectedMethodCommentRequirement" value="Required" />
            <property name="enumCommentRequirement" value="Required" />
            <property name="serialVersionUIDCommentRequired" value="Ignored" />
            <property name="serialPersistentFieldsCommentRequired" value="Ignored" />
        </properties>
    </rule>

</ruleset>
~~~

3. maven 選單  
   lifecycle:clean  
   lifecycle:validate  
   lifecycle:compile  
   plugin:pmd:check

4. pmd 產生的報告，根據上面的配置設定會放在
~~~
target/reports/pmd.html
~~~