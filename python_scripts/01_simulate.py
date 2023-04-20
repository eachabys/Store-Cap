import pandas as pd
import random
import os
import shutil
import subprocess


def retrieve_input1(input,columns):
    """Read input"""
    df= pd.read_csv(input1, usecols=columns1)
    product_list = df.values.tolist()
    product_list=sum(product_list,[])
                     #open 00a_input and populate from list 
    return product_list

def retrieve_input2(input,columns):
    """Read input"""
    df= pd.read_csv(input2, usecols=columns2)
    row_list = df.values.tolist()
    row_list=sum(row_list,[])
    rows=len(row_list) 
    return rows

def update_product(rows,product_list):
    """Read input"""
    update_product=[0]*rows
    for i in range(rows):
    	update_product[i]=random.choice(product_list);
    return update_product

def save_product(update_product,output,rows):
    """Save updated_product_id"""
    df = pd.read_csv(output)

    for i in range(rows):
    	df.loc[i, 'product_id']=update_product[i]
    df.to_csv(output, index=False)

if __name__ == '__main__':
    #run the main function
    input1="sales/00b_input.csv"
    columns1 = ["product_id"] 
    retrieve_input1(input1,columns1) 
    input2="sales/00a_input.csv"
    columns2 = ["Row ID"] 
    rows=retrieve_input2(input2,columns2) 
    product_list=retrieve_input1(input1,columns1)
    update_product=update_product(rows,product_list)
    output="sales/01_output.csv"
    save_product(update_product,output,rows)
