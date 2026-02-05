package Injam.WillYouBeMyValentine;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValentineController {

    @GetMapping("/valentine")
    public String valentine() {
        return """
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Valentine 💖</title>

            <style>
                body {
                    margin: 0;
                    height: 100vh;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    background: linear-gradient(135deg, #ff758c, #ff7eb3);
                    font-family: 'Segoe UI', sans-serif;
                    overflow: hidden;
                    transition: background 1s ease;
                }

                .container {
                    text-align: center;
                    color: white;
                    position: relative;
                    z-index: 2;
                }

                .message {
                    font-size: 2.4rem;
                    font-weight: 600;
                    text-shadow: 0 0 15px rgba(255,255,255,0.7);
                    animation: fadeZoom 2s ease-in-out;
                }

                .heart-text {
                    display: inline-block;
                    animation: heartbeat 1.5s infinite;
                }

                .buttons {
                    margin-top: 30px;
                }

                button {
                    font-size: 1.2rem;
                    padding: 12px 30px;
                    margin: 10px;
                    border: none;
                    border-radius: 30px;
                    cursor: pointer;
                    transition: transform 0.2s, box-shadow 0.2s;
                }

                .yes {
                    background: #ff4d6d;
                    color: white;
                    box-shadow: 0 4px 15px rgba(255,77,109,0.6);
                }

                .no {
                    background: white;
                    color: #ff4d6d;
                }

                button:hover {
                    transform: scale(1.05);
                }

                .reaction {
                    margin-top: 25px;
                    font-size: 1.6rem;
                    animation: fadeZoom 1s ease-in-out;
                }

                /* Floating hearts */
                .heart {
                    position: absolute;
                    bottom: -20px;
                    animation: floatUp 6s linear infinite;
                    opacity: 0.8;
                    z-index: 1;
                }

                @keyframes floatUp {
                    0% {
                        transform: translateY(0) scale(1);
                        opacity: 0;
                    }
                    20% { opacity: 1; }
                    100% {
                        transform: translateY(-110vh) scale(1.4);
                        opacity: 0;
                    }
                }

                @keyframes fadeZoom {
                    from { opacity: 0; transform: scale(0.85); }
                    to { opacity: 1; transform: scale(1); }
                }

                @keyframes heartbeat {
                    0% { transform: scale(1); }
                    25% { transform: scale(1.1); }
                    40% { transform: scale(1); }
                    60% { transform: scale(1.15); }
                    100% { transform: scale(1); }
                }

                @media (max-width: 480px) {
                    .message { font-size: 1.8rem; }
                    button { font-size: 1rem; padding: 10px 24px; }
                }
            </style>
        </head>

        <body>

            <div class="container">
                <div class="message">
                    <span class="heart-text">❤️ Will you be my Valentine LATA? ❤️</span>
                </div>

                <div class="buttons">
                    <button class="yes" onclick="yesClicked()">Yes 💕</button>
                    <button class="no" onclick="noClicked()">No 🙈</button>
                </div>

                <div id="reaction" class="reaction"></div>
            </div>

            <script>
                function yesClicked() {
                    document.body.style.background =
                        "linear-gradient(135deg, #ff9a9e, #fad0c4)";
                    document.getElementById("reaction").innerHTML =
                        "🥰 Yayyy! You just make me HAPPY, FUCHKU! 💖🌹";
                }

                function noClicked() {
                    document.body.style.background =
                        "linear-gradient(135deg, #89f7fe, #66a6ff)";
                    document.getElementById("reaction").innerHTML =
                        "😄 It’s okay… you’re GORU! 🌸";
                }

                // Floating hearts generator
                const hearts = 30;
                for (let i = 0; i < hearts; i++) {
                    const heart = document.createElement("div");
                    heart.className = "heart";
                    heart.innerHTML = "❤️";
                    heart.style.left = Math.random() * 100 + "vw";
                    heart.style.animationDelay = Math.random() * 6 + "s";
                    heart.style.fontSize = (14 + Math.random() * 26) + "px";
                    document.body.appendChild(heart);
                }
            </script>

        </body>
        </html>
        """;
    }
}
