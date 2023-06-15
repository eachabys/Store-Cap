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

def login_get():
    """get login info"""
    df = pd.read_csv("../input_data/login_info.csv", sep="\t", header=0)
    names = df.keys().values.tolist()
    names= names[0].split(",")
    df1=df.values.tolist()
    df=sum(df1,[])
    df1=df[0].split(",")
    if len(df)>1:
        for i in range(1,len(df),1):
            temp=df[i]
            temp=temp.split(",")
            for j in range(len(df1)):
                df1[j]=df1[j]+","+temp[j]
    df1=[x.split(",") for x in df1]
    data=dict(zip(names, df1))
    return data

def login_output():
    """output login info"""
    data = login_get()
    db = create_engine(conn_string)
    conn = db.connect()
    # Create DataFrame
    df = pd.DataFrame(data)
    df.to_sql('login', con=conn, if_exists='replace',index=False)
    conn = psycopg2.connect(conn_string)
    conn.autocommit = True
    cursor = conn.cursor()
    conn.close()

def orders_get():
    """get login info"""
    df = pd.read_csv("../input_data/01_output_test.csv", sep="\t", header=0)
    names = df.keys().values.tolist()
    names= names[0].split(",")
    df1=df.values.tolist()
    """df=sum(df1,[])
    df1=df[0].split(",")
    if len(df)>1:
        for i in range(1,len(df),1):
            temp=df[i]
            temp=temp.split(",")
            for j in range(len(df1)):
                df1[j]=df1[j]+","+temp[j]
    df1=[x.split(",") for x in df1]
    x=df1[3]
    for i in range(len(x)):
        z=(x[i].split('-'))[1]
        x[i]=z
    df1[3]=x
    x=df1[4]
    k=copy.deepcopy(x)
    y=copy.deepcopy(x)
    for i in range(len(x)):
        z=(x[i].split(' '))
        k[i]=z[0]
        y[i]=" ".join(z[1:])
    df1[4]=k
    df1.append(y)
    names=['id', 'product_id', 'order_date', 'customer_id', 'name', 'city', 'state', 'zip_code', 'region', 'sales', 'quantity', 'last_name']
    data=dict(zip(names, df1))
    return data"""
    print(df1)

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

def product_get():
    """get login info"""
    df = pd.read_csv("../input_data/00c_input.csv", sep="\t", header=0)
    names = df.keys().values.tolist()
    names= names[0].split(",")
    names=names[:-2]
    df1=df.values.tolist()
    df=sum(df1,[])
    df1=df[0].split(",")
    if len(df)>1:
        for i in range(1,len(df),1):
            temp=df[i]
            temp=temp.split(",")
            for j in range(len(df1)):
                df1[j]=df1[j]+","+temp[j]
    df1=[x.split(",") for x in df1]
    data=dict(zip(names, df1))
    return data

def product_output():
    """output login info"""
    data = product_get()
    db = create_engine(conn_string)
    conn = db.connect()
    # Create DataFrame
    df = pd.DataFrame(data)
    df.to_sql('product', con=conn, if_exists='replace',index=False)
    conn = psycopg2.connect(conn_string)
    conn.autocommit = True
    cursor = conn.cursor()
    conn.close()

if __name__ == '__main__':
    conn_string = 'postgresql://efarrar:90@localhost:5432/testdb'
    #login_output()
    orders_get()
    #orders_get()
    #product_output() 


