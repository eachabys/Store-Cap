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

def orders_output():
    """output login info"""
    text="productid   weight  fat_content category   outlet_type"
    text=text.split(' ')
    cols=[x for x in text if x!='']
    df = pd.read_csv("../input_data/products.csv",usecols=cols);
    #df=df[:4]
    db = create_engine(conn_string)
    conn = db.connect()
    # Create DataFrame
    df = pd.DataFrame(df)
    df.to_sql('products', con=conn, if_exists='replace',index=False)
    conn = psycopg2.connect(conn_string)
    conn.autocommit = True
    cursor = conn.cursor()
    conn.close()

if __name__ == '__main__':
    conn_string = 'postgresql://efarrar:90@localhost:5432/testdb'
    #login_output()
    orders_output()
    #customer_fix()





