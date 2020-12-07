package day2
import scala.util.chaining._

object ValidatePassword {
  def validatePasswords(passwords: Seq[PasswordAndRule]) = {
    passwords.count(p =>
      p.password.count(_ == p.letter).pipe(p.range.inclusive.contains)
    )
  }

  def validatePasswordsUpdatedRule(passwords: Seq[PasswordAndRule]) = {
    passwords.count(p =>
      (p.password(p.range.start - 1) == p.letter &&
        p.password(p.range.`end` - 1) != p.letter) ||
        p.password(p.range.start - 1) != p.letter &&
          p.password(p.range.`end` - 1) == p.letter
    )
  }
}

case class PasswordAndRule(range: Range, letter: Char, password: String)

object ParseInput {
  def parse(input: String) = {
    input
      .replace(":", "")
      .linesIterator
      .map(_.split(" ") match {
        case Array(range, letter, password) =>
          PasswordAndRule(
            range.split("-").pipe(r => Range(r.head.toInt, r(1).toInt)),
            letter.head,
            password
          )
      })
      .toSeq
  }
}
