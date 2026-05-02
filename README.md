# TicTacToe AI — Minimax

Konsol üzerinden oynanan, yenilmesi imkansız bir tic-tac-toe (XOX) oyunu. Yapay zeka, **Minimax algoritması** ile oynar; en iyi sonuç alabileceğin senaryo beraberliktir.

## Hakkında

Bu proje benim sıfırdan yazdığım bir kod değildir. Bir **LLM (Large Language Model)** tarafından üretilmiştir. Kodu kendi makinemde derleyip çalıştırdım, akışını ve mantığını inceledim. Amacım kodu ezbere yazmak değil, **Minimax algoritmasının nasıl çalıştığını anlamak** ve yapay zekanın karar verme mantığını incelemekti.

Başkalarının da kodu okuyup öğrenmesi için repoya ekliyorum.

## Nasıl çalışır?

İki oyuncu sırayla oynar: kullanıcı **X**, bilgisayar **O**. Tahta 0–8 arası numaralandırılmış 9 hücreden oluşur:

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

## Çalıştırma

Java 8 veya üzeri yeterli.

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

## Notlar

- Kullanıcı geçersiz bir hücre (dolu olan) seçerse program tekrar sorar.
- Klasör adında Türkçe karakter olması Windows + Java kombinasyonunda sorun çıkarabilir; ASCII karakterli bir yol kullanmak daha güvenli.
- Geliştirme fikirleri: alpha-beta budama (büyük tahtalar için), GUI versiyonu, zorluk seviyesi (rastgele hamle yüzdesi).

## Lisans

Eğitim amaçlı, serbestçe kullanılabilir.
