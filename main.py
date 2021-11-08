import pandas as pd
import pathlib

file = input("Introduce path to your file:")
ext = pathlib.Path(file).suffix

if ext == '.xlsx':
    data = pd.read_excel(file)
elif ext == '.xls':
    data = pd.read_excel(file)
elif ext == '.csv':
    data = pd.read_csv(file)
elif ext == '.xml':
    data = pd.read_xml(file)


print(data["email"].unique())
