Feature: Reproducir video en YouTube

  Scenario: Buscar y reproducir un video
    Given abro YouTube
    When busco el video "Rick Astley Never Gonna Give You Up"
    Then reproduzco el primer resultado
