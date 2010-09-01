#!/usr/bin/env perl 

use 5.010;
use utf8;
use strict;
use warnings;

use LWP::UserAgent;
use URI;
use JSON;

binmode STDOUT, ':utf8';

my $query = $ARGV[0];
my $uri = URI->new('http://search.twitter.com/search.json');
$uri->query_form(q => $query);

print $uri->as_string;

my $ua = LWP::UserAgent->new;
my $res = $ua->get($uri);
die 'HTTP Request Error =>' . $res->status_line if !$res->is_success;

my $result = decode_json($res->content);
for my $tweet (@{$result->{results}}) {
    say '【' . $tweet->{from_user} . '】' . $tweet->{text};
}

