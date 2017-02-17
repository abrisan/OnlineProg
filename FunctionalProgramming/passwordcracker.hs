-- solution to
-- https://www.hackerrank.com/challenges/password-cracker-fp

import qualified Data.Text as T
import Control.Monad

prefix :: String -> String -> Bool
prefix xs ys = take (length xs) ys == xs

checkLogin :: [String] -> [String] ->  String -> [String]
checkLogin [] _ xs = ["WRONG PASSWORD"]
checkLogin _ _ [] = []
checkLogin (x:xs) (list) ys |prefix x ys = x : checkLogin (list) (list) (drop (length x) ys)
                            |otherwise = checkLogin xs list ys

getStrings :: String -> [String]
getStrings xs = map T.unpack (T.splitOn (T.pack " ") (T.pack xs))

makeStringFromList :: [String] -> String
makeStringFromList xs = if last xs == "WRONG PASSWORD" then "WRONG PASSWORD" else helper xs
  where
    helper [] = []
    helper (x:xs) |xs == [] =  x
                  |otherwise = x ++ " " ++ helper xs

main = do
  n <- getLine
  replicateM_ (read n :: Int) (
    do
      n2 <- getLine
      string <- getLine
      pass <- getLine
      putStrLn (makeStringFromList (checkLogin (getStrings string) (getStrings string) pass))
      )

