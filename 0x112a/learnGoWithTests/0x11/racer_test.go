package main

import (
	"net/http"
	"net/http/httptest"
	"testing"
	"time"
)

func TestRacer(t *testing.T) {
	//  重构之前
	//	slowURL := "http://www.facebook.com"
	//	fastURL := "http://www.quii.co.uk"
	//
	//	want := fastURL
	//	got := Racer(slowURL, fastURL)
	//
	//	if got != want {
	//		t.Errorf("got '%s', want '%s'", got, want)
	//	}
	//	slowServer := httptest.NewServer(http.HandlerFunc(func(rw http.ResponseWriter, r *http.Request) {
	//		time.Sleep(20 * time.Millisecond)
	//		rw.WriteHeader(http.StatusOK)
	//	}))
	//
	//	fastServer := httptest.NewServer(http.HandlerFunc(func(rw http.ResponseWriter, r *http.Request) {
	//		rw.WriteHeader(http.StatusOK)
	//	}))
	slowServer := makeDelayedServer(20 * time.Millisecond)
	fastServer := makeDelayedServer(0 * time.Millisecond)

	defer slowServer.Close()
	defer fastServer.Close()
	slowURL := slowServer.URL
	fastURL := fastServer.URL

	want := fastURL
	got, _ := Racer(slowURL, fastURL)

	if want != got {
		t.Errorf("got '%s',want '%s'", got, want)
	}

	t.Run("return a erro if a server doesn`t respond within 10s", func(t *testing.T) {
		serverA := makeDelayedServer(11 * time.Second)
		serverB := makeDelayedServer(12 * time.Second)
		defer serverA.Close()
		defer serverB.Close()

		_, err := Racer(serverA.URL, serverB.URL)

		if err == nil {
			t.Errorf("expected an error but didn`t get one")
		}
	})
}

func makeDelayedServer(delay time.Duration) *httptest.Server {
	return httptest.NewServer(http.HandlerFunc(func(rw http.ResponseWriter, r *http.Request) {
		time.Sleep(delay)
		rw.WriteHeader(http.StatusOK)
	}))
}
