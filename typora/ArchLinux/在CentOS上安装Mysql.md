# How To Install MySQL on CentOS 8

### Introduction

[MySQL](https://www.mysql.com/) is an open-source database management system, commonly installed as part of the popular [LEMP](https://www.digitalocean.com/community/tutorials/how-to-install-linux-nginx-mysql-php-lemp-stack-on-centos-8) (Linux, Nginx, MySQL/MariaDB, PHP/Python/Perl) stack. It implements the [relational model](https://en.wikipedia.org/wiki/Relational_model) and [Structured Query Language](https://en.wikipedia.org/wiki/SQL) (SQL) to manage and query data.

This tutorial explains how to install MySQL version 8 on a CentOS 8 server.

## Prerequisites

To complete this tutorial, you will need a server running CentOS 8. This server should have a non-root user with administrative privileges and a firewall configured with `firewalld`. To set this up, see our [Initial Server Setup guide for CentOS 8](https://www.digitalocean.com/community/tutorials/initial-server-setup-with-centos-8).

## Step 1 — Installing MySQL

On CentOS 8, MySQL version 8 is available from the default repositories.

Run the following command to install the `mysql-server` package and a number of its dependencies:

```bash
sudo dnf install mysql-server
```

When prompted, press `y` and then `ENTER` to confirm that you want to proceed:

```
Output. . .
Install  49 Packages

Total download size: 46 M
Installed size: 252 M
Is this ok [y/N]: y
```

With that, MySQL is installed on your server but it isn’t yet operational. The package you just installed configures MySQL to run as a `systemd` service named `mysqld.service`. In order to use MySQL, you will need to start it with the `systemctl` command:

```bash
sudo systemctl start mysqld.service
```



To check that the service is running correctly, run the following command. Note that for many `systemctl` commands — including `start` and, as shown here, `status` — you don’t need to include `.service` after the service name:

```bash
sudo systemctl status mysqld
```



If MySQL was successfully started, the output will show that the MySQL service is active:

```
Output● mysqld.service - MySQL 8.0 database server
   Loaded: loaded (/usr/lib/systemd/system/mysqld.service; enabled; vendor preset: disabled)
   Active: active (running) since Thu 2020-03-12 14:07:41 UTC; 1min 7s ago
 Main PID: 15723 (mysqld)
   Status: "Server is operational"
    Tasks: 38 (limit: 5056)
   Memory: 474.2M
   CGroup: /system.slice/mysqld.service
           └─15723 /usr/libexec/mysqld --basedir=/usr

Mar 12 14:07:32 cent-mysql-3 systemd[1]: Starting MySQL 8.0 database server...
Mar 12 14:07:32 cent-mysql-3 mysql-prepare-db-dir[15639]: Initializing MySQL database
Mar 12 14:07:41 cent-mysql-3 systemd[1]: Started MySQL 8.0 database server.
```

Next, set MySQL to start whenever the server boots up with the following command:

```bash
sudo systemctl enable mysqld
```



**Note:** If you ever want to change this behavior and disable MySQL from starting up at boot, you can do so by running:`sudo systemctl disable mysqld ` Copy

MySQL is now installed, running, and enabled on your server. Next, we’ll go over how to harden your database’s security using a shell script that came preinstalled with your MySQL instance.

## Step 2 — Securing MySQL

MySQL includes a security script that allows you to change some default configuration options in order to improve MySQL’s security.

To use the security script, run the following command:

```bash
sudo mysql_secure_installation
```



This will take you through a series of prompts asking if you want to make certain changes to your MySQL installation’s security options. The first prompt will ask whether you’d like to set up the Validate Password Plugin, which you can use to test the strength of your MySQL password.

If you elect to set up the Validate Password Plugin, the script will ask you to choose a password validation level. The strongest level — which you select by entering `2` — will require your password to be at least eight characters long and include a mix of uppercase, lowercase, numeric, and special characters:

```
OutputSecuring the MySQL server deployment.

Connecting to MySQL using a blank password.

VALIDATE PASSWORD COMPONENT can be used to test passwords
and improve security. It checks the strength of password
and allows the users to set only those passwords which are
secure enough. Would you like to setup VALIDATE PASSWORD component?

Press y|Y for Yes, any other key for No: Y

There are three levels of password validation policy:

LOW    Length >= 8
MEDIUM Length >= 8, numeric, mixed case, and special characters
STRONG Length >= 8, numeric, mixed case, special characters and dictionary                  file

Please enter 0 = LOW, 1 = MEDIUM and 2 = STRONG: 2
```

Regardless of whether you choose to set up the Validate Password Plugin, the next prompt will be to set a password for the MySQL **root** user. Enter and then confirm a secure password of your choice:

```
OutputPlease set the password for root here.


New password: 

Re-enter new password: 
```

If you used the Validate Password Plugin, you’ll receive feedback on the strength of your new password. Then the script will ask if you want to continue with the password you just entered or if you want to enter a new one. Assuming you’re satisfied with the strength of the password you just entered, enter `Y` to continue the script:

```
OutputEstimated strength of the password: 100 
Do you wish to continue with the password provided?(Press y|Y for Yes, any other key for No) : Y
```

Following that, you can press `Y` and then `ENTER` to accept the defaults for all the subsequent questions. This will remove some anonymous users and the test database, disable remote root logins, and load these new rules so that MySQL immediately respects the changes you have made.

With that, you’ve installed and secured MySQL on your CentOS 8 server. As a final step, we will test that the database is accessible and working as expected.

## Step 3 — Testing MySQL

You can verify your installation and get information about it by connecting with the `mysqladmin` tool, a client that lets you run administrative commands. Use the following command to connect to MySQL as **root** (`-u root`), prompt for a password (`-p`), and return the installation’s version:

```bash
mysqladmin -u root -p version
```



You will see output similar to this:

Output

```bash
mysqladmin  Ver 8.0.17 for Linux on x86_64 (Source distribution)
Copyright (c) 2000, 2019, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Server version      8.0.17
Protocol version    10
Connection      Localhost via UNIX socket
UNIX socket     /var/lib/mysql/mysql.sock
Uptime:         2 hours 52 min 37 sec

Threads: 2  Questions: 20  Slow queries: 0  Opens: 131  Flush tables: 3  Open tables: 48  Queries per second avg: 0.001
```

This indicates your installation was successful.

If you’d like to connect to MySQL and begin adding data to it, run the following:

```bash
mysql -u root -p
```



Like the previous `mysqladmin` command, this command includes the `-u` option, which allows you to specify the user you’d like to connect as (**root** in this case), and the `-p` option, which tells the command to prompt you for the user password you set in the previous step.

After you enter your **root** MySQL user’s password, you will see the MySQL prompt:

From there, you can begin using your MySQL installation to create and load databases and start running queries.

## Conclusion

By following this tutorial, you’ve installed and secured MySQL on a CentOS 8 server. From here, you could install Nginx and PHP to have a fully operational [LEMP stack](https://www.digitalocean.com/community/tutorials/how-to-install-linux-nginx-mysql-php-lemp-stack-on-centos-8) on your server.

To learn more about using MySQL, we encourage you to review the [official documentation](https://dev.mysql.com/doc/refman/8.0/en/).