FROM tomcat:9.0.81
RUN echo $HOME

# Create the necessary directory structure inside the container
RUN mkdir -p /usr/local/tomcat/webapps/ROOT

# Copy the HTML file to the ROOT directory inside the container
COPY html/signIn.html /usr/local/tomcat/webapps/ROOT/

COPY 4413Project.war /usr/local/tomcat/webapps/

# Install MySQL client for schema initialization
RUN apt-get update && apt-get install -y mysql-client

# Copy the MySQL schema creation script to a directory inside the container
COPY project.sql /docker-entrypoint-initdb.d/

EXPOSE 8080
CMD ["catalina.sh", "run"]