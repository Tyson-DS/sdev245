# ===============================
# Big Test File for Secret Scanner
# ===============================

import os
import requests

# -------------------------------
# Normal variables (should NOT match)
# -------------------------------
username = "john_doe"
email = "john@example.com"
timeout = 30
debug = True

# -------------------------------
# Passwords (should match)
# -------------------------------
password = "admin123"
db_password = "SuperSecretPassword!"
PASSWORD = "Password123!"  # might or might not match depending on regex strictness

# -------------------------------
# API Keys (should match)
# -------------------------------
api_key = "abcdef1234567890"
API_KEY="ZYXWVUTSRQPONMLK1234"

google_api_key = "AIzaSyA_fake_but_realistic_key_123456789"
aws_access_key = "AKIAIOSFODNN7EXAMPLE"

# -------------------------------
# Tokens (should match)
# -------------------------------
token = "ghp_abcdefghijklmnopqrstuvwxyz123456"
auth_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9."
auth_token += "eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIn0."
auth_token += "TJVA95OrM7E2cBab30RMHrHDcEfxjoYZgeFONFh7HgQ"

# -------------------------------
# JWT in one line (should match)
# -------------------------------
jwt_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJ0ZXN0In0.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"

# -------------------------------
# Private Key (should match)
# -------------------------------
private_key = """
-----BEGIN PRIVATE KEY-----
MIIEvQIBADANBgkqhkiG9w0BAQEFAASC
A_fake_private_key_block_for_testing
-----END PRIVATE KEY-----
"""

# -------------------------------
# Random noise (should NOT match)
# -------------------------------
lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit"
numbers = "1234567890"
symbols = "!@#$%^&*()_+-="

# -------------------------------
# Edge cases
# -------------------------------
pass_word = "this_should_not_match"
apikey = "short"
password_hint = "my dog name"
tokenize = "this is not a token"

# -------------------------------
# Mixed content
# -------------------------------
config = {
    "host": "localhost",
    "user": "admin",
    "password": "configPass123",
    "api_key": "CONFIGAPIKEY1234567890"
}

# -------------------------------
# End of test file
# -------------------------------
