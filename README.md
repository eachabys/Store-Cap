# Store Inventory Planner
I have been curious to see the impact a small entity can make for the whole community. The Store Inventory Planner is an app to help local store personnel to keep up with the orders/returns data management without extra operational overhead. Also, the app allows one to see the impact of his/her small store activity on a big scale using the analytical capabilities of the app.

# Dataset
The original orders table (the dataset is available at (https://community.tableau.com/s/question/0D54T00000CWeX8SAL/sample-superstore-sales-excelxls)  was imported into Postgresql database after it went through the modification using a python script. The following data was imported to postgresql:
'id': 'unique row id';<br />
'city':'city where the order was shipped',<br />
'customerid': 'non-unique value', 
'date':'date when the order was ordered', 
'lastname':' Last Name  of a customer who put the order and whose customerid is listed on this order',
'name':'First Name of a customer ut the order and whose customerid is listed on this order', 
'orderid':' unique value identifying the order. It can't be duplicated in this table. It serves as a unique key, defining the order in this table', 
'productid':'product id of the items in this order. Each order can contain only 1 productid, but the quantity of the product can be more than 1 for the same orderid', 
'quantity':'quantity of the items ordered',
'region':'region where the items are shipped',
'returnamount':'the $ amount which was returned after the customer returned some items',
'returnquantity': 'how many items the customer returned',
'returnstatus': 'can be 1 in case if the customer submitted return or 0 if not',
'sales':'$ amount paid for the purchase',
'state':'state where the order was shipped', 
'zip':'zip code where the order was shipped',
'user_id':'of the user who served the order and entered it into db'.

# App Main Features


# Technologies and tools
The repository contains the code and input data for the project Store inventory update. The project can be used by a small store personnel to maintain the records of the orders (sales and returns) without any need for a technical overhead.
Some of the csv files from that dataset are in the folder input_csv. The relevant csv files were migrated to local PostgreSql db usign Python scripts which can be found in python_scripts folder.
The rest of the project was performed using the technologies such as Java, Postgresql, SpringBoot, Maven, Bootstrap and front end Html. The project details can be foud in the folder ordersApp.

# Future Goals

Implement splitting admin and personnel and API for admin.
Implement scheduled update Shopping Analytics. Consider cloud implementation. 
Consider Customer Memoisation and decoupling.
Personal Analytics page (specific for a particular user) implementation. 

# Author

👤 Elmira Farrar
Linkedin: @efarra
Github: @eachabys

Please ⭐️ this repository if this project helped you!

