# Tic-Tac-Toe AI (Minimax - Java)

Bu proje, yapay zekâ rakibine karşı oynanan basit bir Tic-Tac-Toe (XOX) oyunudur.  
Yapay zekâ kısmında Minimax algoritması kullanılmıştır.

---

## Proje Hakkında

- Oyun Java dili ile geliştirilmiştir.
- Yapay zekâ, Minimax algoritması sayesinde optimal hamle yapar.
- Oyun terminal/console üzerinden çalışır.
- İki taraf da hatasız oynarsa oyun berabere biter.

---

## Yapay Zekâ Mantığı

Yapay zekâ, olası tüm hamleleri değerlendirir ve gelecekte oluşabilecek oyun durumlarını hesaplayarak en iyi hamleyi seçer.

Bu projede özellikle:
- Minimax algoritması
- Recursive düşünme mantığı
- Oyun ağacı (game tree) yapısı

konularını anlamaya odaklandım.

---

## Not

Bu proje, ChatGPT desteğiyle geliştirilmiştir.  
Kodun mantığını inceleyip anlamaya çalıştım; özellikle Minimax algoritması ve recursive yapı üzerine öğrenme amaçlı çalıştım.

---

## Bu Projede Öğrendiklerim

- Minimax algoritması
- Recursive fonksiyon mantığı
- Basit yapay zekâ karar mekanizması
- Oyun mantığı oluşturma
- Java'da console tabanlı proje geliştirme

---

## Gelecekte Eklemeyi Düşündüklerim

- Grafik arayüz (GUI)
- Zorluk seviyeleri
- Daha gelişmiş AI davranışları
- Unity’ye taşıma denemeleri

```
0 | 1 | 2
---------
3 | 4 | 5
---------
6 | 7 | 8
```

Bilgisayar her sırasında **Minimax** ile tahtadaki tüm olası hamleleri tarar, her biri için olası sonuçları (kazanç +1, kayıp -1, beraberlik 0) hesaplar ve en yüksek skoru getiren hamleyi oynar. Kullanıcının da en iyi şekilde oynayacağını varsayar — yani “rakip de mükemmel oynarsa ben ne yapmalıyım?” mantığıyla çalışır.

## Minimax kısaca

- **Maximizing player (O — AI):** Skoru maksimize etmeye çalışır.
- **Minimizing player (X — sen):** Skoru minimize etmeye çalışır (AI senin böyle oynayacağını varsayar).
- Algoritma rekürsif olarak oyun ağacını sona kadar dolaşır, yaprak düğümlerden skoru geri taşır.
- Tic-tac-toe'da arama uzayı küçük olduğu için derinlik kısıtı veya alpha-beta budama gerekmez; tam arama yapılabilir.

Sonuç: AI asla kaybetmez. En iyi yapabileceğin beraberlik.



```bash
javac TicTacToeAI.java
java TicTacToeAI
```

Hamle yaparken 0–8 arası bir numara gir.

## Sınıf yapısı

| Metot | Açıklama |
|---|---|
| `printBoard()` | Tahtanın güncel halini konsola yazdırır |
| `checkWinner(char)` | Verilen oyuncunun kazanıp kazanmadığını kontrol eder |
| `isFull()` | Tahta dolu mu (beraberlik kontrolü için) |
| `minimax(boolean)` | Rekürsif Minimax — pozisyonun skorunu döner |
| `bestMove()` | Tüm boş hücreleri deneyip en iyi skorlu hamleyi seçer |
| `main()` | Oyun döngüsü, kullanıcı girişi ve oyun sonu kontrolü |

## Not

- Kullanıcı geçersiz bir hücre (dolu olan) seçerse program tekrar sorar.
- Klasör adında Türkçe karakter olması Windows + Java kombinasyonunda sorun çıkarabilir; ASCII karakterli bir yol kullanmak daha güvenli.
- Geliştirme fikirleri: alpha-beta budama (büyük tahtalar için), GUI versiyonu, zorluk seviyesi (rastgele hamle yüzdesi).


