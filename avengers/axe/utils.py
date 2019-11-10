from urllib.request import urlopen
import ssl
ssl._create_default_https_context = ssl._create_unverified_context
import html2text

def transfer_html(url):
    html = urlopen(url).read().decode('utf-8')
    return html2text.html2text(html)

if __name__ == "__main__":
    print(transfer_html("https://raven.readthedocs.io/en/stable/integrations/django.html"))
    #print(html2text.html2text(tmp))
