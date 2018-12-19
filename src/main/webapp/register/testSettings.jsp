
    <h3>Please choose desired setting for test...</h3>
    <br>
    <form action="test/start" method="post">
        Step 1:  Number of menu items to be tested on:
        <br>
        <select name="testSize">
            <option value="3">3</option>
            <option value="5">5</option>
            <option value="10">10</option>
            <option value="15">15</option>
        </select>
        <br>
        <br>
        Step 2: Popularity of menu items to be tested:
        <br>
            <input type="radio" name="freq" value="High" checked>High<br>
            <input type="radio" name="freq" value="Med"> Med<br>
            <input type="radio" name="freq" value="Low"> Low
        <br>
        <Br>
        Step 3: Order vocabulary verbage:
        <br>
            <input type="radio" name="language" value="normal" checked>Normal order descriptions<br>
            <input type="radio" name="language" value="slang"> Slang or alternative descriptions<br>
        <br>
        <br>
        <input type="submit" name="submit" value="Start test">

    </form>

