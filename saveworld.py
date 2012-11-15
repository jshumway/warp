import re
import os

## constructor calls
# re.findall  r'\w+\s\w+\s=\snew\s\w+\(.*\);'

## register player function
# re.findall  r'registerPlayer\(p,\s\d+,\s\d+\);'

## get blockRow, wallStack
# re.findall  r'\w+\.wallStack|blockRow\(\d+\);'

## add object
# re.findall  r'addObject\(\w+,\s\d+,\s\d+\);'

# just in case
try:
    os.remove("EditorWorld.java.bak")
except WindowsError:
    pass

os.rename("EditorWorld.java", "EditorWorld.java.bak")

with open("EditorWorld.java", "w") as o:
    for line in open("EditorWorld.java.bak"):
        if not re.search(r'setWorldLocation', line):
            o.write(line)
        if re.search(r'setLocation', line):
            line = line.replace("setLocation", "setWorldLocation")
            o.write(line)
