# Store Inventory Management
I have been curious to see the impact a small entity can make for the whole community. The Store Inventory Planner is an app to help local store personnel to keep up with the orders/returns data management without extra operational overhead. Also, the app allows one to see the impact of his/her small store activity on a big scale using the analytical capabilities of the app.

# Dataset
The original orders table (https://community.tableau.com/s/question/0D54T00000CWeX8SAL/sample-superstore-sales-excelxls) and products table (https://www.kaggle.com/code/dhainjeamita/bigmart-sales-dataset/input ) were imported into Postgresql database after they were modified using python scripts. The following data was imported to postgresql:
'id': 'unique row id';<br />
'city':'city where the order was shipped',<br />
'customerid': 'non-unique value', <br />
'date':'date when the order was ordered', <br />
'lastname':' Last Name  of a customer who put the order and whose customerid is listed on this order',<br />
'name':'First Name of a customer ut the order and whose customerid is listed on this order', <br />
'orderid':' unique value identifying the order. It can't be duplicated in this table. It serves as a unique key, defining the order in this table', <br />
'productid':'product id of the items in this order. Each order can contain only 1 productid, but the quantity of the product can be more than 1 for the same orderid', <br />
'quantity':'quantity of the items ordered',<br />
'region':'region where the items are shipped',<br />
'returnamount':'the $ amount which was returned after the customer returned some items', <br />
'returnquantity': 'how many items the customer returned',<br />
'returnstatus': 'can be 1 in case if the customer submitted return or 0 if not',<br />
'sales':'$ amount paid for the purchase', <br />
'state':'state where the order was shipped', <br />
'zip':'zip code where the order was shipped',<br />
'user_id':'of the user who served the order and entered it into db'.

# App Main Features
-Register a new user (store personnel);<br />
-User login with a unique password;<br />
-Submit an order detail (sale);<br />
-Submit a return for a specific order; <br />
-View/Create custom shopping analysis for the user's needs; <br />

# Technologies and tools
The repository contains the code and input data for the project Store inventory update. The project can be used by a small store personnel to maintain the records of the orders (sales and returns) without any need for a technical overhead.
Some of the csv files from that dataset are in the folder input_csv. The relevant csv files were migrated to local PostgreSql db usign Python scripts which can be found in python_scripts folder.
The rest of the project was performed using the technologies such as Java, Postgresql, SpringBoot, Maven, Bootstrap and front end Html. The project details can be foud in the folder ordersApp.

# Future Goals

-Implement splitting admin and personnel and API for admin.<br />
-Implement scheduled update Shopping Analytics. Consider cloud implementation. <br />
-Consider Customer Memoisation. So, in case of a repeated customer, the user can search for the customer details. <br />
-Personal Analytics page (specific for a particular user) implementation. <br />

# Author

👤 Elmira Farrar<br />
Linkedin: @efarra<br />
Github: @eachabys

Feel free to ⭐️ this repository if this project helped you!

