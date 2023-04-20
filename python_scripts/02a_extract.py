import sys
import os
import configparser
from datetime import datetime
import time
import operator
import psycopg2
import pandas as pd
from sqlalchemy import create_engine
  

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
    df = pd.read_csv("../input_data/01_output.csv", sep="\t", header=0)
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

def orders_output():
    """output login info"""
    data = orders_get()
    db = create_engine(conn_string)
    conn = db.connect()
    # Create DataFrame
    df = pd.DataFrame(data)
    df.to_sql('orders1', con=conn, if_exists='replace',index=False)
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
    conn_string = 'postgresql://username:password@localhost:5432/database'
    login_output()
    orders_output()
    product_output()


