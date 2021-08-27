# 在Ubuntu上安装Mysql

> https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-20-04

## How To Install MySQL on Ubuntu 20.04

UbuntuMySQLDatabasesUbuntu 20.04

By Mark Drake

Last Validated onJuly 30, 2020 Originally Published onApril 23, 2020 289.7kviews
Not using Ubuntu 20.04?
Choose a different version or distribution.
A previous version of this tutorial was written by Hazel Virdó

## Introduction
MySQL is an open-source database management system, commonly installed as part of the popular LAMP (Linux, Apache, MySQL, PHP/Python/Perl) stack. It implements the relational model and uses Structured Query Language (better known as SQL) to manage its data.

This tutorial will go over how to install MySQL version 8.0 on an Ubuntu 20.04 server. By completing it, you will have a working relational database that you can use to build your next website or application.

## Prerequisites
To follow this tutorial, you will need:

One Ubuntu 20.04 server with a non-root administrative user and a firewall configured with UFW. To set this up, follow our initial server setup guide for Ubuntu 20.04.
### Step 1 — Installing MySQL
On Ubuntu 20.04, you can install MySQL using the APT package repository. At the time of this writing, the version of MySQL available in the default Ubuntu repository is version 8.0.19.

To install it, update the package index on your server if you’ve not done so recently:

``` sudo apt update``` 

Then install the mysql-server package:

``` sudo apt install mysql-server ```

This will install MySQL, but will not prompt you to set a password or make any other configuration changes. Because this leaves your installation of MySQL insecure, we will address this next.

### Step 2 — Configuring MySQL
For fresh installations of MySQL, you’ll want to run the DBMS’s included security script. This script changes some of the less secure default options for things like remote root logins and sample users.

Run the security script with sudo:

``` sudo mysql_secure_installation ```

This will take you through a series of prompts where you can make some changes to your MySQL installation’s security options. The first prompt will ask whether you’d like to set up the Validate Password Plugin, which can be used to test the password strength of new MySQL users before deeming them valid.

```sql
修改密码
use mysql; 

update user set authentication_string='' where user='root';      --将字段置为空

alter user 'root'@'localhost' identified with mysql_native_password by '123456';

```

https://stackoverflow.com/questions/62524355/unable-to-start-mysql-server-control-process-exited-with-error-code