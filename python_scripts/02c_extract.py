import sys
import os
import configparser
from datetime import datetime
import time
import operator
import psycopg2
import pandas as pd
from sqlalchemy import create_engine
import copy

def orders_fix():
    """get login info"""
    df = pd.read_csv("../input_data/sample_-_superstore.csv", usecols=['Order_ID']);
    orders = df.values.tolist()
    orders=sum(orders,[])
    for i in range(len(orders)):
        temp=orders[i].split('-')
        temp=temp[-1]
        with open("../input_data/orderid.txt", "a") as myfile:
            myfile.write(temp+ "\n") 

def customer_fix():
    """get login info"""
    df = pd.read_csv("../input_data/sample_-_superstore.csv", usecols=['Customer_ID']);
    customer = df.values.tolist()
    customer=sum(customer,[])
    for i in range(len(customer)):
        temp=customer[i].split('-')
        temp=temp[-1]
        with open("../input_data/customer.txt", "a") as myfile:
            myfile.write(temp+ "\n")

def name_fix():
    """get login info"""
    df = pd.read_csv("../input_data/sample_-_superstore.csv", usecols=['Last_Name']);
    name= df.values.tolist()
    name=sum(name,[])
    for i in range(len(name)):
        temp=name[i].split(' ')
        temp=temp[1:]
        temp=''.join(temp)
        temp=temp.replace("'",'')
        with open("../input_data/name.txt", "a") as myfile:
            myfile.write(temp+ "\n")

def product_fix():
    """get login info"""
    df = pd.read_csv("../input_data/sample_-_superstore.csv", usecols=['Product_ID']);
    product= df.values.tolist()
    product=sum(product,[])
    for i in range(len(product)):
        temp=product[i].split('-')
        temp=temp[-1]
        with open("../input_data/product.txt", "a") as myfile:
            myfile.write(temp+ "\n")

def state_fix():
    """get login info"""
    df = pd.read_csv("../input_data/sample_-_superstore.csv", usecols=['State']);
    abbrevs = {'AK': 'Alaska','AL': 'Alabama','AR': 'Arkansas', 'DC':'District of Columbia','AZ': 'Arizona','CA': 'California','CO': 'Colorado','CT': 'Connecticut','DE': 'Delaware','FL': 'Florida','GA': 'Georgia','HI': 'Hawaii','IA': 'Iowa','ID': 'Idaho','IL': 'Illinois','IN': 'Indiana','KS': 'Kansas','KY': 'Kentucky','LA': 'Louisiana','MA': 'Massachusetts','MD': 'Maryland','ME': 'Maine','MI': 'Michigan','MN': 'Minnesota','MO': 'Missouri','MS': 'Mississippi','MT': 'Montana','NC': 'North Carolina','ND': 'North Dakota','NE': 'Nebraska','NH': 'New Hampshire','NJ': 'New Jersey','NM': 'New Mexico','NV': 'Nevada','NY': 'New York','OH': 'Ohio','OK': 'Oklahoma','OR': 'Oregon','PA': 'Pennsylvania','PR': 'Puerto Rico','RI': 'Rhode Island','SC': 'South Carolina','SD': 'South Dakota','TN': 'Tennessee','TX': 'Texas','UT': 'Utah','VA': 'Virginia','VI': 'Virgin Islands','VT': 'Vermont','WA': 'Washington','WI': 'Wisconsin','WV': 'West Virginia','WY': 'Wyoming'}
    state= df.values.tolist()
    state=sum(state,[])
    a=[]
    for i in range(len(state)):
        temp=state[i]
        a1 = [k for k,v in abbrevs.items() if v==temp ]
        if len(a1)<1:
            print(i)
        a.append(a1)
    a=sum(a,[])
    print(len(a))
    for i in range(len(a)):
        with open("../input_data/state.txt", "a") as myfile:
            myfile.write(a[i]+ "\n")

def orders_output():
    """output login info"""
    data = orders_get()
    db = create_engine(conn_string)
    conn = db.connect()
    # Create DataFrame
    df = pd.DataFrame(data)
    df.to_sql('orders', con=conn, if_exists='replace',index=False)
    conn = psycopg2.connect(conn_string)
    conn.autocommit = True
    cursor = conn.cursor()
    conn.close()




if __name__ == '__main__':
    conn_string = 'postgresql://efarrar:90@localhost:5432/testdb'
    #login_output()
    #orders_fix()
    #customer_fix()
    #product_fix()
    state_fix()
    #orders_get()
    #product_output() 


