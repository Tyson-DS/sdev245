import os
import argparse
import re
import logging

logging.basicConfig(level=logging.INFO,
                    format="%(levelname)s: %(message)s")

Patterens = {
    "AWS Access Key": r"AKIA[0-9A-Z]{16}",
    "Generic API Key": r"api[_-]?key\s*=\s*['\"][A-Za-z0-9-_]{16,}['\"]",
    "Password Assignment": r"password\s*=\s*['\"].+['\"]",
    "JWT Token": r"eyJ[A-Za-z0-9-_]+\.[A-Za-z0-9-_]+\.[A-Za-z0-9-_]+",
    "Private Key": r"-----BEGIN PRIVATE KEY-----"
}

def check(line, file_path, line_num):
    for type, pattern in Patterens.items():
        match = re.search(pattern, line)
        if match: 
            print(
                f"[{type}]"
                f"File: {file_path} | "
                f"Line: {line_num} | "
                f"Match: {match.group()}]"
            )


def scan_file(file_path):
    logging.info(f"Scanning file: {file_path}")
    try: 
        with open(file_path, "r", errors="ignore") as f: 
            for line_num, line in enumerate(f, start=1):
                check(line, file_path, line_num)
    except Exception as e:
        logging.error(f"Could not read file {file_path} ({e})")


def Scan_directory(dir_path):
    logging.info(f"Scanning directory: {dir_path}")
    for root, _, files in os.walk(dir_path):
        for file in files:
            full_Path = os.path.join(root,file)
            scan_file(full_Path)



def main():

    parser = argparse.ArgumentParser( description="Scan files")
    parser.add_argument("path", help="path to a file or directory")

    args = parser.parse_args()
    tpath = args.path 

    if not os.path.exists(tpath):
        logging.error("Path does not exist")
        return
    
    logging.info("Scanning started")
    
    if os.path.isfile(tpath): 
        scan_file(tpath)
    elif os.path.isdir(tpath):
        Scan_directory(tpath)
    else:
        logging.error("Invalid path")
    
    logging.info("Scanning completed")


if __name__ == "__main__":
    main()